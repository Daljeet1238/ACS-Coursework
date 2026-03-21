-- Database Setup Script for ACS-3902 Assignment 2, Part C
-- REPLACE YOUR STUDENT NUMBER AND NAME IN THE STATEMENTS BELOW
create schema if not exists daljeet_3169763_as2_c;
set schema 'daljeet_3169763_as2_c';

create table customer (
    customer_number character varying(3) primary key,
    last character varying(100),
    first character varying(100),
    street character varying(100),
    city character varying(100),
    state character varying(2),
    zip_code character varying(6),
    balance numeric(7,2),
    credit_limit numeric(7,2),
    salesrepnumber character varying(2)
);

create table sales_order (
    order_number character varying(5)  primary key,
    order_date timestamp with time zone not null,
    customer_number character varying(3) not null
);


create table order_line (
    order_number character varying(5) ,
    part_number character varying(4) ,
    qty_ordered numeric(3,0) not null,
    quoted_price numeric(6,2) not null,
	PRIMARY KEY (order_number, part_number)
);


create table part (
    part_number character varying(4) primary key,
    part_description character varying(100),
    units_on_hand numeric(6,0),
    item_class_id integer not null,
    warehouse_id character varying(1),
    unit_price numeric(6,2)
);

create table item_class (
    item_class_id integer primary key,
    item_class_code character varying(2),
    item_class_desc varchar(100),
	UNIQUE (item_class_code)
);

create table sales_commision_payout (
    payoutkey  serial PRIMARY KEY,
    salesrepnumber character varying(2) not null,
    commissionrate numeric(3,2),
    salesyear smallint,
    salesmonthnumber smallint,
    sales numeric(7,2),
    commission numeric(7,2),
	UNIQUE (salesrepnumber, salesyear, salesmonthnumber)
);



create table sales_rep (
    salesrepnumber character varying(2) PRIMARY KEY,
    last character varying(100) not null,
    first character varying(100) not null,
    state character varying(2) not null,
    commission_rate numeric(3,2) not null
);

insert into customer VALUES
	('124', 'Adams', 'Sally', '481 Oak', 'Lansing', 'MI', '49224', 818.75, 1000.00, '03'),
	('256', 'Samuels', 'Ann', '215 Pete', 'Grant', 'MI', '49219', 21.50, 1500.00, null),
	('311', 'Charles', 'Don', '48 College', 'Ira', 'MI', '49034', 825.75, 1000.00, '12'),
	('315', 'Daniels', 'Tom', '914 Cherry', 'Kent', 'MI', '48391', 770.75, 750.00, '06'),
	('405', 'Williams', 'Al', '519 Watson', 'Grant', 'MI', '49219', 402.75, 1500.00, '12'),
	('412', 'Adams', 'Sally', '16 Elm', 'Lansing', 'MI', '49224', 1817.50, 2000.00, null),
	('522', 'Nelson', 'Mary', '108 Pine', 'Ada', 'MI', '49441', 98.75, 1500.00, '12'),
	('567', 'Dinh', 'Tran', '808 Ridge', 'Harper', 'MI', '48421', 402.40, 750.00, '06'),
	('587', 'Galvez', 'Mara', '512 Pine', 'Ada', 'MI', '49441', 114.60, 1000.00, '06'),
	('622', 'Martin', 'Dan', '419 Chip', 'Grant', 'MI', '49219', 1045.75, 1000.00, '03'),
	('623', 'Lopes', 'Antonio', '34 Ridgeway St', 'Bay City', 'MI', '47582', -200.25, 500.00, null);

insert into sales_order  values
	('12489', '2002-09-02 00:00:00-06', '124'),
	('12491', '2002-09-02 00:00:00-06', '311'),
	('12494', '2002-09-04 00:00:00-06', '315'),
	('12495', '2002-09-04 00:00:00-06', '256'),
	('12498', '2002-09-05 00:00:00-06', '522'),
	('12500', '2002-09-05 00:00:00-06', '124'),
	('12504', '2002-09-05 00:00:00-06', '522'),
	('12505', '2002-10-05 00:00:00-06', '256'),
	('12506', '2002-11-05 00:00:00-06', '311'),
	('12507', '2002-11-05 00:00:00-06', '124'),
	('12508', '2002-12-12 00:00:00-06', '124'),
	('12509', '2003-01-09 00:00:00-06', '124');


insert into order_line values
	('12489', 'AX12', 11, 21.95),
	('12491', 'BT04', 1, 149.99),
	('12491', 'BZ66', 1, 399.99),
	('12494', 'CB03', 4, 279.99),
	('12495', 'CX11', 2, 22.95),
	('12498', 'AZ52', 2, 12.95),
	('12498', 'BA74', 4, 24.95),
	('12500', 'BT04', 1, 149.99),
	('12504', 'CZ81', 2, 325.99),
	('12505', 'AZ52', 9, 12.95),
	('12506', 'CB03', 8, 269.99);

insert into part values
	('AX12', 'Iron', 104, 1, '3', 28.95),
	('AZ52', 'Dartboard', 20, 2, '2', 14.95),
	('BA74', 'Basketball', 40, 2, '1', 39.95),
	('BH22', 'Cornpopper', 95, 1, '3', 24.95),
	('BT04', 'Gas Grill', 11, 3, '2', 169.99),
	('BZ66', 'Washer', 52, 3, '3', 399.99),
	('CA14', 'Griddle', 78, 1, '3', 39.99),
	('CB03', 'Bike', 44, 2, '1', 299.99),
	('CX11', 'Blender', 112, 1, '3', 25.00),
	('CZ81', 'Treadmill', 68, 2, '2', 349.95);


insert into item_class values
	(1, 'HW', 'Hardware'),
	(2, 'SG', 'Sporting Goods'),
	(3, 'AP', 'Appliances');


INSERT INTO sales_rep values
	('02', 'Finlay', 'Doug',  'MI', 0.08),
	('03', 'Jones', 'Mary', 'MI', 0.05),
	('04', 'Celina', 'Sanchez', 'WA', 0.02),
	('06', 'Smith', 'William', 'MN',  0.07),
	('12', 'Diaz ', 'Miguel', 'ND', 0.05);

-- FK Constraints
ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_salesrepnumber_fkey FOREIGN KEY (salesrepnumber) REFERENCES sales_rep(salesrepnumber);

ALTER TABLE ONLY order_line
    ADD CONSTRAINT order_line_order_number_fkey FOREIGN KEY (order_number) REFERENCES sales_order(order_number);

ALTER TABLE ONLY order_line
    ADD CONSTRAINT order_line_part_number_fkey FOREIGN KEY (part_number) REFERENCES part(part_number);

ALTER TABLE ONLY sales_commision_payout
    ADD CONSTRAINT sales_commision_payout_salesrepnumber_fkey FOREIGN KEY (salesrepnumber) REFERENCES sales_rep(salesrepnumber);

ALTER TABLE ONLY sales_order
    ADD CONSTRAINT sales_order_customer_number_fkey FOREIGN KEY (customer_number) REFERENCES customer(customer_number);

ALTER TABLE ONLY part
    ADD CONSTRAINT part_item_class_fkey FOREIGN KEY (item_class_id) REFERENCES item_class(item_class_id);