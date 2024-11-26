package ru.apzakharov.demo.port;

import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import ru.apzakharov.demo.port.repository.task.entity.TaskEntity;
import ru.apzakharov.demo.port.repository.taskstate.entity.TaskStateEntity;
public interface TaskPort {
  String getStateById(Long id);

  TaskEntity save(TaskEntity task);

  Page<TaskEntity> getByState(TaskStateEntity state, Pageable pageable);

  TaskEntity getById(Long id);
}
