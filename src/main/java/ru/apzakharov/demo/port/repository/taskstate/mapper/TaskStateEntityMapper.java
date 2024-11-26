package ru.apzakharov.demo.port.repository.taskstate.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import ru.apzakharov.demo.application.model.task.TaskState;
import ru.apzakharov.demo.port.TaskStatePort;
import ru.apzakharov.demo.port.repository.EntityMapper;
import ru.apzakharov.demo.port.repository.taskstate.entity.TaskStateEntity;

@Mapper(imports = TaskStatePort.class,injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@Component
public abstract class TaskStateEntityMapper implements EntityMapper<TaskState, TaskStateEntity> {

  @Autowired
  private TaskStatePort port;

  @Override
  @Cacheable("database_state")
  public TaskStateEntity toEntity(TaskState domain) {
    return port.findByDescription(domain.name());

  }

  @Override
  public TaskState toDomain(TaskStateEntity entity) {
    return TaskState.valueOf(entity.getName().toUpperCase());
  }
}
