alter table tb_user_profile add constraint user_profile_profile foreign key (profile_id) references tb_profile (id);
alter table tb_user_profile add constraint user_profile_user foreign key (user_id) references tb_user (id);
