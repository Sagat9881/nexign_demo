package ru.apzakharov.demo.adapter.listener.task;

import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.apzakharov.demo.adapter.listener.Listener;
import ru.apzakharov.demo.adapter.listener.task.mapper.TaskListenerMapper;
import ru.apzakharov.demo.adapter.listener.task.model.TaskListenerDto;
import ru.apzakharov.demo.service.usecase.task.SaveTaskUseCase;

@Configuration
@RequiredArgsConstructor
public class TaskListener implements Listener {

  private final TaskListenerMapper mapper;
  private final SaveTaskUseCase saveTaskUseCase;

  @Bean
  public Consumer<TaskListenerDto> taskConsumer() {
    return taskDto ->
        saveTaskUseCase.execute(mapper.toDomain(taskDto));
  }

}
