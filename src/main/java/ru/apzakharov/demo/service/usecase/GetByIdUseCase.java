package ru.apzakharov.demo.service.usecase;

import org.springframework.stereotype.Component;
import ru.apzakharov.demo.application.model.task.Task;
@Component
public interface GetByIdUseCase extends UseCase {

  Task getById(Long id);

}
