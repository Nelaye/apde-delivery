drop database if exists deliveryDB;

create database if not exists deliveryDB;

use deliveryDB;

create table deliveries (
    id int not null auto_increment primary key,
    buyer int not null,
    date datetime not null,
    address varchar(255)
);

