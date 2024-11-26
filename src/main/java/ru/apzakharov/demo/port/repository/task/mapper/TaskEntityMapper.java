package ru.apzakharov.demo.port.repository.task.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.apzakharov.demo.application.model.task.Task;
import ru.apzakharov.demo.application.model.task.TaskState;
import ru.apzakharov.demo.port.repository.EntityMapper;
import ru.apzakharov.demo.port.repository.task.entity.TaskEntity;
import ru.apzakharov.demo.port.repository.taskstate.mapper.TaskStateEntityMapper;

@Mapper(uses = TaskStateEntityMapper.class)
public interface TaskEntityMapper extends EntityMapper<Task, TaskEntity> {

  @Mapping(target = "state", expression = "java(taskStateEntityMapper.toEntity(state))")
  TaskEntity toEntity(Task task, @Context TaskState state);
}
