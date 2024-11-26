package ru.apzakharov.demo.adapter.controller.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.apzakharov.demo.adapter.controller.ControllerDto;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStateDto implements ControllerDto {

  @JsonProperty("description")
  private String description;
  @JsonProperty("name")
  private String name;


}
