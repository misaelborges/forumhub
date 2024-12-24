alter table tb_topic add constraint topic_user_id foreign key (user_id) references tb_user (id);

alter table tb_topic add constraint topic_curse_id foreign key (course_id) references tb_course (id);