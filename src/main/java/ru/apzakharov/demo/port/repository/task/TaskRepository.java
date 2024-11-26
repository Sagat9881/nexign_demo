package ru.apzakharov.demo.port.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.apzakharov.demo.port.TaskPort;
import ru.apzakharov.demo.port.repository.task.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>, TaskPort {

  @Override
  @Query(value = """
      Select (select s.description from demo.state as s where s.id=t_s.state_id) from demo.task as t 
      left join demo.task_state t_s on 
          t.task_id = t_s.task_id
      where t.task_id = :id              
      """,nativeQuery = true)
  String getStateById(@Param("id") Long id);

//  @Override
//  @Query(value = """
//      Select (select s.description from demo.state as s where s.id=t_s.state_id) from demo.task as t
//      left join demo.task_state t_s on
//          t.task_id = t_s.task_id
//      """,nativeQuery = true)
//  String getByLastState(@Param("id") Long id);
}
