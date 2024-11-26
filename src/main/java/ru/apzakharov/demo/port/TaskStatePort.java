package ru.apzakharov.demo.port;

import ru.apzakharov.demo.port.repository.taskstate.entity.TaskStateEntity;

public interface TaskStatePort {

  TaskStateEntity findByDescription(String description);

}
