package ru.apzakharov.demo.port.repository.taskstate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import ru.apzakharov.demo.port.repository.EntityWithId;


@Data
@Entity
@Table(name = "state",schema = "demo")
public class TaskStateEntity implements EntityWithId<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "description")
  private String description;
  @Column(name = "name")
  private String name;
}
