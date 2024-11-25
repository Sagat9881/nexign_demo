package ru.apzakharov.demo.adapter.controller.task.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.apzakharov.demo.adapter.controller.ControllerDto;
import ru.apzakharov.demo.adapter.controller.task.TaskController;
import ru.apzakharov.demo.adapter.controller.task.mapper.TaskControllerMapper;
import ru.apzakharov.demo.adapter.controller.task.model.ExceptionDto;
import ru.apzakharov.demo.adapter.controller.task.model.TaskDto;
import ru.apzakharov.demo.service.usecase.GetByIdUseCase;

@Service
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

  private final GetByIdUseCase getById;
  private final TaskControllerMapper mapper;

  @Override
  public ResponseEntity<ControllerDto> getById(Long id) {
    try {
      return ok(mapper.toDto(getById.getById(id)));
    } catch (Exception e) {
      return internal(new ExceptionDto(id, e.getMessage()));
    }
  }

  @Override
  public String getStateById(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<ControllerDto> post(TaskDto task) {
    return null;
  }
}
