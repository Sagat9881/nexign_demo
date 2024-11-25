package ru.apzakharov.demo.adapter.controller.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.apzakharov.demo.adapter.controller.Controller;
import ru.apzakharov.demo.adapter.controller.ControllerDto;
import ru.apzakharov.demo.adapter.controller.task.model.TaskDto;

@RestController("/task")
public interface TaskController extends Controller {

  @GetMapping("/{id}")
  ResponseEntity<ControllerDto> getById(@PathVariable("id") Long id);

  @GetMapping("/state/{id}")
  String getStateById(@PathVariable("id") Long id);

  @PostMapping
  ResponseEntity<ControllerDto> post(@RequestBody TaskDto task);
}
