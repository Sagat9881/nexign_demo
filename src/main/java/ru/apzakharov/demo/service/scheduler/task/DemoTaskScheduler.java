package ru.apzakharov.demo.service.scheduler.task;

import static ru.apzakharov.demo.application.model.task.TaskState.FAIL;
import static ru.apzakharov.demo.application.model.task.TaskState.ON_PROGRESS;
import static ru.apzakharov.demo.application.model.task.TaskState.REGISTERED;
import static ru.apzakharov.demo.application.model.task.TaskState.SUCCESS;

import jakarta.annotation.PostConstruct;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.apzakharov.demo.application.model.task.Task;
import ru.apzakharov.demo.port.TaskPort;
import ru.apzakharov.demo.port.repository.task.mapper.TaskEntityMapper;
import ru.apzakharov.demo.port.repository.taskstate.mapper.TaskStateEntityMapper;
import ru.apzakharov.demo.service.scheduler.Scheduler;

@Component
@RequiredArgsConstructor
public class DemoTaskScheduler implements Scheduler {

  private final TaskPort port;
  @Value("${service.worker.count}")
  private int parallelism;
  @Value("${service.worker.batch-size}")
  private int batchSize;
  private final TaskEntityMapper taskMapper;
  private final TaskStateEntityMapper stateMapper;
  private ForkJoinPool forkJoinPool;

  @PostConstruct
  void init() {
    this.forkJoinPool = new ForkJoinPool(parallelism);
  }

  @Transactional
  @Scheduled(fixedRate = 3000)
  void schedule() {
    port.getByState(stateMapper.toEntity(REGISTERED), PageRequest.ofSize(batchSize)).stream().toList()
        .stream()
        .peek(entity -> entity.setState(stateMapper.toEntity(ON_PROGRESS)))
        .map(taskMapper::toDomain)
        .map(DoTask::new)
        .forEach(forkJoinPool::invoke);
  }

  @RequiredArgsConstructor
  private class DoTask extends RecursiveAction {

    final private Task task;

    @Override
    protected void compute() {
      try {
        Thread.sleep(task.duration().toMillis());
        port.save(taskMapper.toEntity(task, SUCCESS));
      } catch (InterruptedException e) {
        port.save(taskMapper.toEntity(task, FAIL));
        throw new RuntimeException(e);
      }
    }
  }
}
