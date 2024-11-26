package ru.apzakharov.demo.port.repository.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import ru.apzakharov.demo.port.repository.EntityWithId;

@Entity
@Table(name = "state")
@Data
public class TaskStateEntity implements EntityWithId<Long> {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "description")
  private String description;
  @Column(name = "name")
  private String name;
}
