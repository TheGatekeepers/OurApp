create database hackend;

create table hackend.devices (
	id integer primary key auto_increment,
	username varchar(8000) not null,
	qr_string varchar(8000) not null,
	device_id varchar(8000) null
);
