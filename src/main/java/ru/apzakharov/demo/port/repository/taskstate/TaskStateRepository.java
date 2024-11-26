package ru.apzakharov.demo.port.repository.taskstate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.apzakharov.demo.port.TaskStatePort;
import ru.apzakharov.demo.port.repository.task.entity.TaskStateEntity;
@Repository
public interface TaskStateRepository extends JpaRepository<TaskStateEntity, Long>, TaskStatePort {

  TaskStateEntity findByName(String name);

}
