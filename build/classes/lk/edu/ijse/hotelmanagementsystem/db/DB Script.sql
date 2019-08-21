drop database HotelManagementSystem;
create database HotelManagementSystem;
use HotelManagementSystem;

CREATE TABLE system_User(
	suid VARCHAR(10) NOT NULL,
	user_level varchar(100),
	user_name VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL,	

	CONSTRAINT PRIMARY KEY(suid)
);

create table customer(
	cid varchar(20),
	f_name varchar(100),
	l_name varchar(100),
	email varchar(100),
	address varchar(500),
	country varchar(100),
        pas_portId varchar(100),
	NIC varchar(100),
	tel int(20),
	
	CONSTRAINT PRIMARY KEY (cid)
);

create table registration(
	reid varchar(20),
	cid varchar(20),
	checkin varchar(100) NOT NULL,
	checkout varchar(100) NOT NULL,
	no_of_rooms int,
	no_of_adults varchar(100),
	no_of_children varchar(100),
        meal_type varchar(100),

	CONSTRAINT PRIMARY KEY (reid),
	CONSTRAINT FOREIGN KEY(cid) REFERENCES customer(cid) 
	ON Delete Cascade On update cascade
);

create table facility(
	fid varchar(20),
	facility_Name varchar(100) NOT NULL,
        prices decimal(65,2),
	
	CONSTRAINT PRIMARY KEY (fid)
);

create table facility_Detail(
	fid varchar(20),
	reid varchar(200),
	
	CONSTRAINT FOREIGN KEY(fid) REFERENCES facility(fid) 
	ON Delete Cascade On update cascade,
	CONSTRAINT FOREIGN KEY(reid) REFERENCES registration(reid) 
	ON Delete Cascade On update cascade
);

create table service(
	sid varchar(20),
	service_name varchar(100) NOT NULL,
	price decimal(65,2),

	CONSTRAINT PRIMARY KEY (sid)
);

create table service_detail(
	sid varchar(20),
	reid varchar(200),
	
	CONSTRAINT FOREIGN KEY(sid) REFERENCES service(sid) 
	ON Delete Cascade On update cascade,
	CONSTRAINT FOREIGN KEY(reid) REFERENCES registration(reid) 
	ON Delete Cascade On update cascade
);

create table room(
	rid varchar(20),
	room_type varchar(100) NOT NULL,
	room_floor  varchar(100) NOT NULL,
	bed_type varchar(100),
	room_decription  varchar(100),
	room_number varchar(100) NOT NULL,
	prices decimal(65,2),
	
	CONSTRAINT PRIMARY KEY (rid)
);

create table room_detail(
	rid varchar(20),
	reid varchar(20),
	
	CONSTRAINT FOREIGN KEY(rid) REFERENCES room(rid) 
	ON Delete Cascade On update cascade,
	CONSTRAINT FOREIGN KEY(reid) REFERENCES registration(reid) 
	ON Delete Cascade On update cascade
);

create table card(
	caid varchar(20),
        bank  varchar(100),
	card_id  varchar(100),
        advances decimal(65,2),
        amount decimal(65,2),

	CONSTRAINT PRIMARY KEY (caid)
);

create table cash(
	csid varchar(20),
        advances decimal(65,2),
        amount decimal(65,2),

	CONSTRAINT PRIMARY KEY (csid)
);

create table checak(
	ckid varchar(20),
        bank  varchar(100),
	check_id  varchar(100),
        advances decimal(65,2),
        amount decimal(65,2),

	CONSTRAINT PRIMARY KEY (ckid)
);

create table payment_method(
	pmid varchar(20),
        reid varchar(20),
        caid varchar(20),
        csid varchar(20),
        ckid varchar(20),
        date  varchar(50),
        tax decimal(65,2),
	discount decimal(65,2),
	amount decimal(65,2),
	balance decimal(65,2),

	CONSTRAINT PRIMARY KEY (pmid),
        CONSTRAINT FOREIGN KEY(reid) REFERENCES registration(reid) 
	ON Delete Cascade On update cascade,
        CONSTRAINT FOREIGN KEY(caid) REFERENCES card(caid) 
	ON Delete Cascade On update cascade,
        CONSTRAINT FOREIGN KEY(csid) REFERENCES cash(csid) 
	ON Delete Cascade On update cascade,
        CONSTRAINT FOREIGN KEY(ckid) REFERENCES checak(ckid) 
	ON Delete Cascade On update cascade
);


insert into service values
('S0001','Lundary',2000.00),
('S0002','Room Service',00.00),
('S0003','Child Services',2000.00),
('S0004','Dry Clening',2500.00),
('S0005','Wellness Center',5000.00),
('S0006','Car hire',2500.00);

insert into facility values
('F0001','Internet',2000.00),
('F0002','Massage',2000.00),
('F0003','News Papaer',2000.00),
('F0004','Fitness Center',2000.00);

insert into room values
('R0001','Normal Room','1 st','Singal ','A/C',00001,80000.00),
('R0002','Normal Room','1 st','Singal ','A/C',00002,80000.00),
('R0003','Normal Room','1 st','Singal ','A/C',00003,80000.00),
('R0004','Normal Room','1 st','Singal ','A/C',00004,80000.00),
('R0005','Normal Room','2 nd','Singal ','A/C',00005,80000.00),
('R0006','Luxury Room','2 nd','Singal ','A/C',00006,80000.00),
('R0007','Luxury Room','2 nd','Singal ','A/C',00007,80000.00),
('R0008','Luxury Room','2 nd','Singal ','A/C',00007,80000.00),
('R0009','Luxury Room','2 nd','Singal ','A/C',00008,80000.00),
('R0010','Luxury Room','3 rd','Singal ','A/C',00009,80000.00),
('R0011','Luxury Room','3 rd','Singal ','A/C',00010,80000.00),
('R0012','Super Luxury Room','3 rd','Singal ','A/C',00012,80000.00),
('R0013','Super Luxury Room','3 rd','Singal ','A/C',00013,80000.00),
('R0014','Super Luxury Room','3 rd','Singal ','A/C',00014,80000.00),
('R0015','Super Luxury Room','3 rd','Singal ','A/C',00015,80000.00);