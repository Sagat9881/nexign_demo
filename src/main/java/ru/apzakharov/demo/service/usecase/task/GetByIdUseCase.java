package ru.apzakharov.demo.service.usecase.task;

import ru.apzakharov.demo.application.model.task.Task;
import ru.apzakharov.demo.service.usecase.UseCase;

public interface GetByIdUseCase extends UseCase {

  Task getById(Long id);

}
