package ru.apzakharov.demo.service.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.apzakharov.demo.port.TaskPort;
import ru.apzakharov.demo.service.usecase.GetStateById;

@Component
@RequiredArgsConstructor
public class GetStateByIdImpl implements GetStateById {

  private final TaskPort taskPort;

  @Override
  public String getStateById(Long id) {
    return taskPort.getStateById(id);
  }
}
