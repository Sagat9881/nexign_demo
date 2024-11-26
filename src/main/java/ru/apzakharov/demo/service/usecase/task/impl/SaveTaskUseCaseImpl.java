package ru.apzakharov.demo.service.usecase.task.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.apzakharov.demo.application.model.task.Task;
import ru.apzakharov.demo.port.TaskPort;
import ru.apzakharov.demo.port.repository.task.mapper.TaskEntityMapper;
import ru.apzakharov.demo.service.usecase.task.SaveTaskUseCase;

@Component
@RequiredArgsConstructor
public class SaveTaskUseCaseImpl implements SaveTaskUseCase {

  private final TaskPort taskPort;
  private final TaskEntityMapper mapper;

  @Override
  public Task execute(Task task) {
    return
        mapper.toDomain(
            taskPort.save(
                mapper.toEntity(task)
            )
        );
  }
}
