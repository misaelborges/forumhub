alter table tb_response add constraint response_user_id foreign key (user_id) references tb_user (id);

alter table tb_response add constraint response_topic_id foreign key (topic_id) references tb_topic (id);