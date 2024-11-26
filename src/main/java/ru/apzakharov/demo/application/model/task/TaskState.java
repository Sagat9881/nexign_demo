package ru.apzakharov.demo.application.model.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.apzakharov.demo.application.model.Domain;

@AllArgsConstructor
@Getter
public enum TaskState implements Domain {
  REGISTERED("Задача зарегистрирована","REGISTERED"),
  ON_PROGRESS("Задача выполняется","ON_PROGRESS"),
  FAIL("Задача завершилась с ошибкой","FAIL"),
  SUCCESS("Задача успешно завершилась","SUCCESS");
  private final String description;
  private final String name;
}
