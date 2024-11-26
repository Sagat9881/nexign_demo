package ru.apzakharov.demo.port.repository.taskstate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "state")
@Data
public class TaskStateEntity {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "description")
  private String description;
}