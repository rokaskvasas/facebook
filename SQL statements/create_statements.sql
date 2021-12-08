use facebook;

create table if not exists role(
id int auto_increment primary key,
title varchar(50) not null,
description text not null
);

create table if not exists user_role(
role_id int not null,
user_id int not null,

foreign key fk_role_id (role_id) references role(id),
foreign key fk_user_id (permission_id) references user(id)
);

create table if not exists user(
id bigint auto_increment primary key not null,
first_name varchar(50) not null,
last_name  varchar(50) not null,
email varchar(255) not null,
username varchar(255) not null,
password varchar(255) not null,
registered_at timestamp not null,
unique index idx_email(email)
);

create table if not exists post(
id bigint auto_increment primary key,
user_id bigint not null,
post_text text not null,
created_at datetime not null,
updated_at datetime null default null,
foreign key fk_user_id(user_id) references user(id)
);



create table if not exists comments(
id bigint auto_increment primary key,
post_id bigint not null,
user_id bigint not null,
created_at datetime not null,
updated_at datetime null default null,
comment_text text not null,
foreign key fk_post_id(post_id) references post(id),
foreign key fk_user_id(user_id) references user(id)
);





