package ru.apzakharov.demo.port.repository.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Duration;
import lombok.Data;
import ru.apzakharov.demo.port.repository.EntityWithId;

@Entity
@Data
@Table(name = "task")
public class TaskEntity implements EntityWithId<Long> {

  @Id
  @Column(name = "id")
  @GeneratedValue
  private Long id;
  @Column(name = "duration")
  private Duration duration;

}
