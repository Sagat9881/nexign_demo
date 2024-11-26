package ru.apzakharov.demo.adapter.controller.task.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.apzakharov.demo.adapter.controller.ControllerMapper;
import ru.apzakharov.demo.adapter.controller.task.model.TaskDto;
import ru.apzakharov.demo.application.model.task.Task;
@Mapper
public interface TaskControllerMapper extends ControllerMapper<TaskDto, Task> {

  @Override
  @Mapping(target = "state",expression = "java(new TaskStateDto( domain.state().getDescription(), domain.state().getName() ) )")
  @Mapping(target = "duration",expression = "java( domain.duration().toMillis() )")
  TaskDto toDto(Task domain);

  @Override
  @Mapping(target = "state",expression = "java( TaskState.valueOf( dto.getState().getName().toUpperCase() ) )")
  @Mapping(target = "duration",expression = "java( Duration.ofMillis( dto.getDuration() ) )")
  Task toDomain(TaskDto dto);
}
