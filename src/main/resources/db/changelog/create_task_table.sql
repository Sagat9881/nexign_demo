create schema demo

create table demo.task
(
    task_id  serial primary key,
    state_id bigint,
    version  int,
    duration interval
);

create table demo.state
(
    id          serial primary key,
    name        varchar,
    description varchar
);


ALTER TABLE demo.task
    ADD CONSTRAINT fk_task_state
        FOREIGN KEY (state_id)
            REFERENCES demo.state (id)

