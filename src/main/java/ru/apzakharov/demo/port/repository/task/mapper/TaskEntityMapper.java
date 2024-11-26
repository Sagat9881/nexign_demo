package ru.apzakharov.demo.port.repository.task.mapper;

import org.mapstruct.Mapper;
import ru.apzakharov.demo.application.model.task.Task;
import ru.apzakharov.demo.port.repository.EntityMapper;
import ru.apzakharov.demo.port.repository.task.entity.TaskEntity;
@Mapper(componentModel = "spring")
public interface TaskEntityMapper extends EntityMapper<Task, TaskEntity> {

}
