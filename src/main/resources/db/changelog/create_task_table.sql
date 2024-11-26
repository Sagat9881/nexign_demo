create table task(
                     task_id serial primary key ,
                     version int,
                     duration interval
)