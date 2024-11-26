package ru.apzakharov.demo.service.usecase.task;

import org.springframework.stereotype.Component;
import ru.apzakharov.demo.application.model.task.Task;
import ru.apzakharov.demo.service.usecase.UseCase;

@Component
public interface GetByIdUseCase extends UseCase {

  Task getById(Long id);

}
