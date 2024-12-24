create table tb_response (
    id bigint not null auto_increment,
    message varchar(255),
    topic_id bigint,
    creation_date datetime(6),
    user_id bigint,
    solution bit,

    primary key (id)
) engine=InnoDB;