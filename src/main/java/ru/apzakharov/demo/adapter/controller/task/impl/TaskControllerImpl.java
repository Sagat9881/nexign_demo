package ru.apzakharov.demo.adapter.controller.task.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.apzakharov.demo.adapter.controller.ControllerDto;
import ru.apzakharov.demo.adapter.controller.task.TaskController;
import ru.apzakharov.demo.adapter.controller.task.mapper.TaskControllerMapper;
import ru.apzakharov.demo.adapter.controller.task.model.ExceptionDto;
import ru.apzakharov.demo.adapter.controller.task.model.TaskDto;
import ru.apzakharov.demo.service.usecase.task.GetByIdUseCase;
import ru.apzakharov.demo.service.usecase.task.GetStateById;
import ru.apzakharov.demo.service.usecase.task.SaveTaskUseCase;

@Service
@RequiredArgsConstructor
public class TaskControllerImpl implements TaskController {

  private final GetByIdUseCase getByIdUseCase;
  private final GetStateById getStateByIdUseCase;
  private final SaveTaskUseCase saveTaskUseCase;

  private final TaskControllerMapper mapper;

  @Override
  public ResponseEntity<ControllerDto> getById(Long id) {
    try {
      return ok(mapper.toDto(getByIdUseCase.getById(id)));
    } catch (Exception e) {
      return internal(new ExceptionDto(id, e.getMessage()));
    }
  }

  @Override
  public String getStateById(Long id) {
    try {
      return getStateByIdUseCase.execute(id);
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public ResponseEntity<ControllerDto> post(TaskDto task) {
    try {
      return ok(mapper.toDto(saveTaskUseCase.execute(mapper.toDomain(task))));
    } catch (Exception e) {
      return internal(new ExceptionDto(task.getId(), e.getMessage()));
    }
  }
}
