package ru.apzakharov.demo.application.model.task;

import java.time.Duration;
import ru.apzakharov.demo.application.model.Domain;

public record Task (Long id,TaskState state, Duration duration) implements Domain {

}
