package ru.apzakharov.demo.adapter.controller.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


public class ExceptionDto extends TaskDto {

  @JsonProperty("message")
  @Getter
  private final String message;

  public ExceptionDto(long id, String message) {
    super(id, -1L);
    this.message = message;
  }
}
