package ru.apzakharov.demo.service.usecase.task.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.apzakharov.demo.application.model.task.Task;
import ru.apzakharov.demo.port.TaskPort;
import ru.apzakharov.demo.port.repository.task.mapper.TaskEntityMapper;
import ru.apzakharov.demo.service.usecase.task.GetByIdUseCase;
@Component
@RequiredArgsConstructor
public class GetByIdUseCaseImpl implements GetByIdUseCase {

  private final TaskPort port;
  private final TaskEntityMapper mapper;
  @Override
  public Task getById(Long id) {
    return mapper.toDomain( port.getById(id) );
  }
}
