package ru.apzakharov.demo.adapter.controller.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.apzakharov.demo.adapter.controller.ControllerDto;

@Data
@RequiredArgsConstructor
public class TaskDto implements ControllerDto {

  @JsonProperty("id")
  private final long id;

  @JsonProperty("duration")
  private final Long duration;

  @JsonProperty("state")
  private final TaskStateDto state;
}
