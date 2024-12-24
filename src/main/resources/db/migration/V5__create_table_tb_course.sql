create table tb_course (
    id bigint not null auto_increment,
    name varchar(255),
    category varchar(255),

    primary key (id)
) engine=InnoDB;