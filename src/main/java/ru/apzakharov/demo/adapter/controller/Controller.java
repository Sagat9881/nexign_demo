package ru.apzakharov.demo.adapter.controller;

import org.springframework.http.ResponseEntity;
import ru.apzakharov.demo.adapter.controller.task.model.ExceptionDto;

public interface Controller {

  default <R extends ControllerDto> ResponseEntity<R> ok(R result){
    return ResponseEntity.ok(result);
  }

  default  <R extends ControllerDto> ResponseEntity<R> badRequest(R result){
    return ResponseEntity.badRequest().body(result);
  }
  default <R extends ControllerDto>ResponseEntity<R> internal(R message){
    return ResponseEntity.internalServerError().body(message);
  }

  default  <R extends ControllerDto> ResponseEntity<R> exception(R result,int status){
    return ResponseEntity.status(status).body(result);
  }



}
