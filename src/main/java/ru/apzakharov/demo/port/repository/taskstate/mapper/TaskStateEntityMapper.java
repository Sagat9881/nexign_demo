package ru.apzakharov.demo.port.repository.taskstate.mapper;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import ru.apzakharov.demo.application.model.task.TaskState;
import ru.apzakharov.demo.port.TaskStatePort;
import ru.apzakharov.demo.port.repository.EntityMapper;
import ru.apzakharov.demo.port.repository.task.entity.TaskStateEntity;

@Mapper
@Component
@RequiredArgsConstructor
public abstract class TaskStateEntityMapper implements EntityMapper<TaskState, TaskStateEntity> {


  private final TaskStatePort port;

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
