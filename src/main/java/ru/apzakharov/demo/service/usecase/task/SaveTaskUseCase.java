package ru.apzakharov.demo.service.usecase.task;

import ru.apzakharov.demo.application.model.task.Task;

public interface SaveTaskUseCase {

  Task execute(Task task);

}
