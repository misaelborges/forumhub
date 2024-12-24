create table tb_topic (
    id bigint not null auto_increment,
    title varchar(255),
    message varchar(255),
    creation_date datetime,
    topic_status enum ('CLOSED','NOT_ANSWERED','RESOLVED','UNRESOLVED'),
    user_id bigint,
    course_id bigint,

    primary key (id)
) engine=InnoDB;