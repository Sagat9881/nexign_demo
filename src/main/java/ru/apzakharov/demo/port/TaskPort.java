package ru.apzakharov.demo.port;

import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.jpa.repository.Lock;
import ru.apzakharov.demo.application.model.task.TaskState;
import ru.apzakharov.demo.port.repository.task.entity.TaskEntity;
import ru.apzakharov.demo.port.repository.task.entity.TaskStateEntity;

public interface TaskPort {
  String getStateById(Long id);

  TaskEntity save(TaskEntity task);
  @Lock(LockModeType.OPTIMISTIC)
  List<TaskEntity> getByState(TaskState state, int batchSize);

  void updateStateById(Long id, TaskStateEntity success);
}
