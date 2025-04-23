
use deliveryontime;

create table user (
user_id long,
name varchar (255),
email varchar(255)
);

create table location(
location_id long,
country varchar(255),
city varchar(255),
CONSTRAINT location_pk PRIMARY KEY
(location_id)
);

create table customer(
customer_id long,
address varchar(255),
location_id long,
CONSTRAINT customer_id_fk FOREIGN KEY
(customer_id) REFERENCES user(user_id),

CONSTRAINT customer_location_fk FOREIGN KEY
(location_id) REFERENCES location(location_id) #current location
);

create table vehicle(
vehicle_id long,
model int,
location_id long,
status enum("Active","In Transit","Reserved","Inactive"),
CONSTRAINT vehicle_pk
PRIMARY KEY (vehicle_id),

CONSTRAINT vehicle_location_fk FOREIGN KEY
(location_id) REFERENCES location(location_id)
);

create table rider(
user_id long, 
vehicle_id long,

CONSTRAINT rider_id_fk FOREIGN KEY
(user_id) REFERENCES user(user_id),
CONSTRAINT customer_vehicle_id_fk FOREIGN KEY
(vehicle_id) REFERENCES vehicle(vehicle_id)
);


create table truck(
vehicle_id long,
cargo_capacity int,
CONSTRAINT truck_id_fk FOREIGN KEY
(vehicle_id) REFERENCES vehicle(vehicle_id)
);

create table Ship(
vehicle_id long,
tonnage int,
CONSTRAINT ship_id_fk FOREIGN KEY
(vehicle_id) REFERENCES vehicle(vehicle_id)
);

create table airplane(
vehicle_id long,
max_payload int,
CONSTRAINT airplane_id_fk FOREIGN KEY
(vehicle_id) REFERENCES vehicle(vehicle_id)
);

create table payment(
payment_id long,
payment_date date,
payment_amount double,
payment_method enum("cod","Credit"),
customer_id long,

CONSTRAINT payment_id_fk FOREIGN KEY
(customer_id) REFERENCES customer(customer_id)
);


create table orders( 		#order is a keyword 
order_id long,
completion_date date,
status enum("In Transit","Delivered","Yet to be Shipped"),
placement_date date,
customer_id long,
payment_id long,

CONSTRAINT order_pk PRIMARY KEY(order_id),

CONSTRAINT order_customer_fk FOREIGN KEY
(customer_id) REFERENCES customer(customer_id),

CONSTRAINT payment_id_fk FOREIGN KEY
(payment_id) REFERENCES payment(payment_id)

);

create table parcel(
parcel_id long, 
typep  varchar(255),
weight double,
order_id long,
origin_id long,
destination_id long,

CONSTRAINT parcel_pk PRIMARY KEY (parcel_id),

CONSTRAINT parcel_order_fk FOREIGN KEY
(order_id) REFERENCES order_(order_id),

CONSTRAINT parcel_origin_fk FOREIGN KEY
(origin_id) REFERENCES location(location_id),

CONSTRAINT parcel_destination_fk FOREIGN KEY
(destination_id) REFERENCES location(location_id)
);

create table batch(
batch_id long, 
origin_id long,
destination_id long,
vehicle_id long,

CONSTRAINT batch_pk PRIMARY KEY (batch_id),
CONSTRAINT batch_origin_fk FOREIGN KEY
(origin_id) REFERENCES origin(origin_id),
CONSTRAINT batch_destination_fk FOREIGN KEY
(destination_id) REFERENCES destination(destination_id),
CONSTRAINT batch_vehicle_fk FOREIGN KEY
(vehicle_id) REFERENCES vehicle(vehicle_id)

);

create table rating(
rating_id long,
stars int,
review varchar (511),
receiver_id long,
sender_id long,

CONSTRAINT rating_receiver_fk FOREIGN KEY
(receiver_id) REFERENCES customer(customer_id),

CONSTRAINT rating_sender_fk FOREIGN KEY
(sender_id) REFERENCES customer(customer_id)
);

create table parcel_batch(

parcel_id long,
batch_id long,

CONSTRAINT parcel_fk FOREIGN KEY
(parcel_id) REFERENCES parcel(parcel_id),
CONSTRAINT batch_id_fk FOREIGN KEY
(batch_id) REFERENCES batch(batch_id) 

)



