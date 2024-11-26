package ru.apzakharov.demo.adapter.controller.task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.apzakharov.demo.adapter.controller.ControllerMapper;
import ru.apzakharov.demo.adapter.controller.task.model.TaskDto;
import ru.apzakharov.demo.application.model.task.Task;
@Mapper(componentModel = "spring")
public interface TaskControllerMapper extends ControllerMapper<TaskDto, Task> {

  @Override
  @Mapping(target = "taskDto.state",expression = "java(new TaskStateDto(domain.state.description(), domain.state.name()))")
  TaskDto toDto(Task domain);

  @Override
  @Mapping(target = "task.state",expression = "java(TaskState.valueOf(dto.getName().toUpperCase()))")
  Task toDomain(TaskDto dto);
}
