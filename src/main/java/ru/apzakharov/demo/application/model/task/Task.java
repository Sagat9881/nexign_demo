package ru.apzakharov.demo.application.model.task;

import ru.apzakharov.demo.application.model.Domain;

public record Task (Long id, String description) implements Domain {

}
