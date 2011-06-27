create database hackend;

create table hackend.devices (
	id integer primary key auto_increment,
	username varchar(8000) not null,
	qr_string varchar(8000) not null,
	device_id varchar(8000) null
);

create table hackend.user_orders (
	id integer primary key auto_increment,
	username varchar(8000) not null,
	order_image_set integer not null,
	correct_image_index integer not null
);

insert into hackend.user_orders (username, order_image_set, correct_image_index) values ('user1@amazon.com', 0, 3);
insert into hackend.user_orders (username, order_image_set, correct_image_index) values ('user2@amazon.com', 1, 1);
insert into hackend.user_orders (username, order_image_set, correct_image_index) values ('user3@amazon.com', 0, 7);
insert into hackend.user_orders (username, order_image_set, correct_image_index) values ('user4@amazon.com', 1, 9);
