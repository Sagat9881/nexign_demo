package ru.apzakharov.demo.adapter.controller.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.apzakharov.demo.adapter.controller.ControllerDto;
@Data
public class TaskStateDto implements ControllerDto {

  @JsonProperty("description")
  private String description;
  @JsonProperty("name")
  private String name;


}
