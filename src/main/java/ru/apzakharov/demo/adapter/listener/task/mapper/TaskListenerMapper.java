package ru.apzakharov.demo.adapter.listener.task.mapper;

import org.mapstruct.Mapper;
import ru.apzakharov.demo.adapter.listener.ListenerMapper;
import ru.apzakharov.demo.adapter.listener.task.model.TaskListenerDto;
import ru.apzakharov.demo.application.model.task.Task;
@Mapper(componentModel = "spring")
public interface TaskListenerMapper extends ListenerMapper<TaskListenerDto, Task> {

}
