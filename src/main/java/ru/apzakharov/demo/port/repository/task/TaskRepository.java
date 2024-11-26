package ru.apzakharov.demo.port.repository.task;

import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.apzakharov.demo.port.TaskPort;
import ru.apzakharov.demo.port.repository.task.entity.TaskEntity;
import ru.apzakharov.demo.port.repository.taskstate.entity.TaskStateEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>, TaskPort {

  @Override
  @Query(value = """
      Select (select s.description from state as s where s.id = t.state_id) from task as t 
      where t.task_id = :id              
      """,nativeQuery = true)
  String getStateById(@Param("id") Long id);
  @Override
  @Lock(LockModeType.OPTIMISTIC)
  @Query(value = """
      update demo.task 
      set state_id = :#{#state.id}
      returning *;
       """,nativeQuery = true)
  Page<TaskEntity> getByState(@Param(value = "state") TaskStateEntity state,
                             Pageable pageable);




}
