create table car
(
	id bigint GENERATED BY DEFAULT AS IDENTITY,
	body_type varchar(255),
	color varchar(255),
	is_free boolean,
	model varchar(255),
	price double,
	transmission varchar(255),
	vehicle_number varchar(255),
	primary key(id)
);

create table client
(
    id bigint GENERATED BY DEFAULT AS IDENTITY,
    address varchar(255),
    experience int,
    name varchar(255),
    passport varchar(255),
    patronymic varchar(255),
    phone_number varchar(255),
    surname varchar (255),
    primary key(id)
);

create table contract
(
     id bigint GENERATED BY DEFAULT AS IDENTITY,
     date_of_end date,
     date_of_start date,
     total_cost double,
     car_id bigint,
     client_id bigint,
     primary key(id),
     foreign key(car_id) references car(id),
     foreign key(client_id) references client(id)
);

create table accident
(
     id bigint GENERATED BY DEFAULT AS IDENTITY,
     date_of_accident date,
     cost_of_damage double,
     contract_id bigint,
     primary key(id),
     foreign key(contract_id) references contract(id)
);