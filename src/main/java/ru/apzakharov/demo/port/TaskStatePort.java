package ru.apzakharov.demo.port;

import ru.apzakharov.demo.port.repository.task.entity.TaskStateEntity;

public interface TaskStatePort {

  TaskStateEntity findByDescription(String description);

}
