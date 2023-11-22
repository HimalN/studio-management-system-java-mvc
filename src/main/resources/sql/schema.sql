create database if not exists shadow_studio;

use shadow_studio;

create table user(
    use_name varchar(10)primary key ,
    password varchar(8)not null
);

create table employee(
    emp_id varchar(10)primary key,
    emp_name varchar(20)not null,
    emp_address varchar(50)not null,
    emp_nic varchar(15)not null,
    emp_tp int not null
);

create table customer(
    cust_id varchar (10)primary key ,
    cust_name varchar(15)not null ,
    cust_address varchar(50) not null ,
    cust_nic varchar(10)not null ,
    cust_tp int not null
);

create table packages(
    package_id varchar (10)Primary key,
    package_name varchar(15)not null,
    package_type varchar(10)not null,
    package_description varchar (50)not null,
    package_price int not null
);

create table bookings(
    booking_id varchar(10)primary key,
    cust_id varchar(10) not null ,
    foreign key (cust_id)references customer(cust_id)on update cascade on delete cascade ,
    cust_name varchar(20),
    package_id varchar(10) not null ,
    foreign key (package_id)references packages(package_id) on update cascade on delete cascade ,
    package_name varchar (20),
    Date date not null ,
    Time time not null ,
    location varchar(100) not null ,
    description varchar(200)
);

create table complains(
    complain_id varchar(10)primary key,
    cust_id varchar(10)not null ,
    foreign key (cust_id)references customer(cust_id)on update cascade on delete cascade ,
    cust_name varchar (20),
    about_complain varchar(150)
);

create table item(
    itemId varchar(10)primary key ,
    itemName varchar(20)not null ,
    itemType varchar(10)not null ,
    rentalPrice double
);

create table rent(
    rentId varchar(10)primary key ,
    cust_id varchar(10)not null ,
    foreign key (cust_id)references customer(cust_id)on update cascade on delete cascade ,
    itemId varchar(10) ,
    foreign key (itemId)references item(itemId) on update cascade on delete cascade,
    dayCount int,
    Date date
);

create table rent_item_details(
    itemId varchar(10),
    foreign key (itemId)references item(itemId)on update cascade on delete cascade,
    cust_id varchar(10),
    foreign key (cust_id)references customer(cust_id)
);

create table employee_booking_details(
    bookingId varchar(10),
    foreign key (bookingId)references bookings(booking_id)on UPDATE cascade on DELETE cascade ,
    employee_Id varchar(10),
    foreign key (employee_Id)references employee(emp_id) on UPDATE cascade on DELETE cascade
);