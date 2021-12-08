use facebook;
insert into role(title, description) values 
('ROLE_ADMIN','IT system admin'),
('ROLE_USER','register user');


insert into user_role(role_id, user_id) values
(1,1),
(2,2),
(3,2);

insert into user (first_name, last_name, email,username, password, registered_at) values
('admin','admin','admin@admin.com','admin','admin',current_timestamp()),
('John','Smith','Smith@test.com','Smithy','smithy',current_timestamp()),
('Alex','Pascal','pascal@test.com','Pascalo','pascalo',current_timestamp());

insert into post ( user_id, post_text, created_at, updated_at) values
(2,'Hello everyone!','2021-12-08 18:03:38',null),
(3,'Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or another type of compatible computer. Text messages may be sent over a cellular network, or may also be sent via an Internet connection.'
,'2021-12-08 18:05:13',null);

insert into comment(comment_text, created_at, post_id, updated_at, user_id) values
('Very interesting! :)','2021-12-08 18:08:56',2,null,2);

