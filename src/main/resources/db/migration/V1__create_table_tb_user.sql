create table tb_user (
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null,
    password varchar(100) not null,

    primary key (id)
) engine=InnoDB;