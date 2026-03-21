-- Daljeet Singh 3169763

-- replace the schema name with your name/st# (pay attention to case sensitivity)
create schema if not exists daljeet_3169763_as2_a_b;
set schema 'daljeet_3169763_as2_a_b';

-- bookingsource
create table bookingsource (
    bookingsourceid integer PRIMARY KEY,
    bookingsourcedescription character varying(255)
);


-- cleaninginvoice
create table cleaninginvoice (
    cleaninginvoicenumber integer PRIMARY KEY,
    invoicestatus character varying(255),
    estimatedate timestamp with time zone,
    bookingdate timestamp with time zone,
    billedtoaccountdate timestamp with time zone,
    cleaningservicedate timestamp with time zone,
    bookingsourceid integer ,
    customerid integer not null,
    estimatedcharge numeric(7,2)
);

-- cleaninginvoiceitem
create table cleaninginvoiceitem (
    cleaninginvoicenumber integer,
    invoicelineitemnumber integer,
    serviceitemid varchar(2),
    servicequantity numeric(13,2) not null,
    serviceunitprice numeric(7,2)  not null,
    servicechargebeforediscount numeric(7,2),
    discountapplied numeric(3,2),
    discountamount numeric(7,2),
    servicechargeafterdiscount numeric(7,2) 
);


-- customer
create table customer (
    customerid integer PRIMARY KEY,
    customertype character varying(255) not null,
    businessname character varying(255),
    firstname character varying(255),
    lastname character varying(255),
    email character varying(255) not null,
    address character varying(255),
    city character varying(255),
    state character varying(2),
    postalcode character varying(6),
    salesrepnumber integer
);

create table customerreferral (
    referralid integer PRIMARY KEY,
    referraldate timestamp with time zone,
    referringcustomer integer NOT NULL,
    referredcustomer integer NOT NULL,
    referralcommissionearned numeric(7,2) not null
);


create table salesrep (
    salesrepnumber integer primary key,
    salesrepfirstname character varying(255) not null,
    salesreplastname character varying(255) not null,
    salesrepcommissionrate numeric(3,2) not null
);


create table serviceitem (
    serviceitemid varchar(2) PRIMARY KEY,
    description character varying(255),
    unittype character varying(50),
    standardunitprice numeric(7,2),
    category character varying(255)
);

-- BookingSource
INSERT INTO "bookingsource" VALUES (1, 'Whistleclean.com');
INSERT INTO "bookingsource" VALUES (2, 'Kijiji');
INSERT INTO "bookingsource" VALUES (3, 'Facebook Marketplace');
INSERT INTO "bookingsource" VALUES (4, 'Call Center');
INSERT INTO "bookingsource" VALUES (5, 'Craig''s List');

-- CleaningInvoice
INSERT INTO cleaninginvoice VALUES (1, 'Billed', '2023-05-21 02:00:00-04', '2023-05-22 02:00:00-04', '2023-06-17 02:00:00-04', '2023-06-12 02:00:00-04', 4, 1, 257);
INSERT INTO cleaninginvoice VALUES (2, 'Billed', '2022-08-19 02:00:00-04', '2022-09-01 02:00:00-04', '2022-09-22 02:00:00-04', '2022-09-19 02:00:00-04', NULL, 3, 14);
INSERT INTO cleaninginvoice VALUES (3, 'Billed', NULL, '2022-09-12 02:00:00-04', '2022-09-28 02:00:00-04', '2022-09-26 02:00:00-04', 2, 12, NULL);
INSERT INTO cleaninginvoice VALUES (4, 'Estimate', '2023-08-27 02:00:00-04', '2023-09-09 02:00:00-04', NULL, NULL, NULL, 4, 262);
INSERT INTO cleaninginvoice VALUES (5, 'Estimate', '2023-09-09 02:00:00-04', '2023-09-12 02:00:00-04', NULL, NULL, 2, 10, 62);
INSERT INTO cleaninginvoice VALUES (6, 'Estimate', '2022-12-11 01:00:00-05', '2022-12-23 01:00:00-05', NULL, NULL, 3, 11, 435);
INSERT INTO cleaninginvoice VALUES (7, 'Billed', '2022-10-27 02:00:00-04', '2022-11-16 01:00:00-05', '2022-11-29 01:00:00-05', '2022-11-27 01:00:00-05', 1, 10, 496);
INSERT INTO cleaninginvoice VALUES (8, 'Estimate', '2023-09-03 02:00:00-04', '2023-09-12 02:00:00-04', NULL, NULL, 3, 3, 430);
INSERT INTO cleaninginvoice VALUES (9, 'Estimate', '2022-11-22 01:00:00-05', '2022-12-08 01:00:00-05', NULL, NULL, NULL, 4, 160);
INSERT INTO cleaninginvoice VALUES (10, 'Billed', '2022-08-29 02:00:00-04', '2022-09-01 02:00:00-04', '2022-09-06 02:00:00-04', '2022-09-05 02:00:00-04', 1, 7, 272);

-- CleaningInvoiceItem
INSERT INTO cleaninginvoiceitem VALUES (1, 1, '1', 6.00, 22, 132, 0.00, 0, 132);
INSERT INTO cleaninginvoiceitem VALUES (1, 2, '2', 1.00, 125, 125, 0.10, 12.5, 112.5);
INSERT INTO cleaninginvoiceitem VALUES (2, 1, '6', 1.00, 18, 18, 0.30, 5.4, 12.6);
INSERT INTO cleaninginvoiceitem VALUES (3, 1, '7', 75.00, 0.4, 30, 0.00, 0, 30);
INSERT INTO cleaninginvoiceitem VALUES (3, 2, '3', 1200.00, 0.25, 300, 0.20, 60, 240);
INSERT INTO cleaninginvoiceitem VALUES (4, 1, '11', 1.00, 140, 140, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (4, 1, '3', 250.00, 0.25, 62.5, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (4, 1, '9', 2.00, 30, 60, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (5, 1, '3', 250.00, 0.25, 62.5, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (6, 1, '6', 1.00, 18, 18, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (6, 2, '12', 2.00, 40, 80, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (6, 2, '6', 2.00, 18, 36, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (6, 2, '3', 500.00, 0.25, 125, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (6, 2, '1', 8.00, 22, 176, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (7, 1, '2', 4.00, 125, 500, 0.20, 100, 400);
INSERT INTO cleaninginvoiceitem VALUES (7, 2, '7', 75.00, 0.4, 30, 0.30, 9, 21);
INSERT INTO cleaninginvoiceitem VALUES (7, 3, '6', 3.00, 18, 54, 0.00, 0, 54);
INSERT INTO cleaninginvoiceitem VALUES (7, 4, '06', 1.00, 18, 18, 0.20, 3.6, 14.4);
INSERT INTO cleaninginvoiceitem VALUES (7, 5, '1', 8.00, 22, 176, 0.20, 35.2, 140.8);
INSERT INTO cleaninginvoiceitem VALUES (7, 6, '7', 120.00, 0.4, 48, 0.20, 9.6, 38.4);
INSERT INTO cleaninginvoiceitem VALUES (8, 1, '8', 250.00, 0.35, 87.5, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (8, 2, '1', 4.00, 22, 88, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (8, 3, 'OT', 500.00, 0.35, 175, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (8, 4, '10', 1.00, 80, 80, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (9, 5, NULL, 400.00, 0.4, 160, NULL, NULL, NULL);
INSERT INTO cleaninginvoiceitem VALUES (10, 1, '6', 2.00, 18, 36, 0.30, 10.8, 25.2);
INSERT INTO cleaninginvoiceitem VALUES (10, 2, '01', 4.00, 22, 88, 0.00, 0, 88);
INSERT INTO cleaninginvoiceitem VALUES (10, 3, '05', 1.00, 180, 180, 0.20, 36, 144);
INSERT INTO cleaninginvoiceitem VALUES (10, 4, '6', 2.00, 18, 36, 0.00, 0, 36);

-- Customer
INSERT INTO customer VALUES (1, 'Residential', NULL, 'Eddy', 'Birkin', 'ebirkin0@wikipedia.org', '083 Ludington Parkway', 'Grand Rapids', 'MI', '49518', 1);
INSERT INTO customer VALUES (2, 'Commercial', 'Buckridge, Tromp and Murazik', 'Lamar', 'Khilkov', 'lkhilkov1@census.gov', '9864 Welch Road', 'Mobile', 'AL', '36610', NULL);
INSERT INTO customer VALUES (3, 'Residential', NULL, 'Davy', 'Sadd', 'dsadd2@phoca.cz', '5563 Rowland Court', 'Mobile', 'AL', '36610', NULL);
INSERT INTO customer VALUES (4, 'Commercial', 'Conn Inc', 'Ring', 'Fould', 'rfould3@wufoo.com', '74311 Namekagon Junction', 'Washington', 'DC', '20078', 2);
INSERT INTO customer VALUES (5, 'Commercial', 'Von, Barrows and Jerde', 'Brandise', 'Tesh', 'btesh4@exblog.jp', '2770 Norway Maple Center', 'Washington', 'DC', '20546', NULL);
INSERT INTO customer VALUES (6, 'Residential', NULL, 'Desirae', 'Enriques', 'denriques5@gmail.com', '58265 Clove Plaza', 'Topeka', 'KS', '66642', NULL);
INSERT INTO customer VALUES (7, 'Residential', NULL, 'Van', 'Turpey', 'vturpey6@hubpages.com', '010 Dapin Plaza', 'Valley Forge', 'PA', '19495', NULL);
INSERT INTO customer VALUES (8, 'Residential', NULL, 'Mandel', 'Undrell', 'mundrell7@amazonaws.com', '4 Dexter Hill', 'Milwaukee', 'WI', '53215', 4);
INSERT INTO customer VALUES (9, 'Residential', NULL, 'Carce', 'Cerith', 'ccerith8@purevolume.com', '6847 Brentwood Point', 'Dallas', 'TX', '75358', NULL);
INSERT INTO customer VALUES (10, 'Residential', NULL, 'Brodie', 'Kuhn', 'bkuhn9@cdbaby.com', '22252 Continental Way', 'Anderson', 'SC', '29625', 4);
INSERT INTO customer VALUES (11, 'Residential', NULL, 'B', 'Kuhn', 'bkuhn9@cdbaby.com', null, null, null, '29625', 4);	
INSERT INTO customer VALUES (12, 'Commercial', 'Dickens, Beier and Denesik', 'Ker', 'Stut', 'kstutb@phpbb.com', '7 Continental Place', 'Buffalo', 'NY', '14215', 6);
INSERT INTO customer VALUES (13, 'Commercial', 'Baumbach, Labadie and Ortiz', 'Berti', 'Blankhorn', 'bblankhornc@addthis.com', '59493 Washington Terrace', 'Corona', 'CA', '92883', NULL);
INSERT INTO customer VALUES (14, 'Residential', NULL, 'Jamill', 'Godber', 'jgodberd@hc360.com', '440 Hallows Terrace', 'San Jose', 'CA', '95133', 7);
INSERT INTO customer VALUES (15, 'Residential', NULL, 'Filmer', 'Aindriu', 'faindriue@symantec.com', '7 Alpine Avenue', 'Oakland', 'CA', '94616', 7);
INSERT INTO customer VALUES (16, 'Commercial', 'Douglas Group', 'Kerri', 'Fritschel', 'kfritschelf@gmail.com', '90984 Utah Circle', 'Greensboro', 'NC', '27455', NULL);
INSERT INTO customer VALUES (17, 'Residential', NULL, 'Grover', 'Cathcart', 'gcathcartg@paypal.com', '8 Arkansas Place', 'North Little Rock', 'AR', '72118', 6);
INSERT INTO customer VALUES (18, 'Commercial', 'Adams, Armstrong and Towne', 'Grover', 'Cathcart', 'gcathcartg@paypal.com', '81947 Briar Crest Circle', 'Knoxville', 'TN', '37914', 6);
INSERT INTO customer VALUES (19, 'Residential', NULL, 'Sylvester', 'Merwood', 'smerwoodi@gmail.com', '3524 Armistice Court', 'El Paso', 'TX', '79955', 7);
INSERT INTO customer VALUES (20, 'Residential', NULL, 'Anatole', 'McElhinney', 'amcelhinneyj@ucoz.ru', '9 Moulton Court', 'Saint Louis', 'MO', '63110', 7);


-- CustomerReferral
INSERT INTO customerreferral VALUES (1, '2023-05-06 02:00:00-04', 10, 12, 22.27);
INSERT INTO customerreferral VALUES (2, '2023-05-04 02:00:00-04', 10, 13, 18.57);
INSERT INTO customerreferral VALUES (3, '2023-06-13 02:00:00-04', 10, 14, 22.35);
INSERT INTO customerreferral VALUES (4, '2023-03-17 02:00:00-04', 12, 18, 16.06);
INSERT INTO customerreferral VALUES (5, '2023-06-17 02:00:00-04', 12, 19, 17.15);
INSERT INTO customerreferral VALUES (6, '2023-07-17 02:00:00-04', 12, 20, 17.66);
INSERT INTO customerreferral VALUES (7, '2023-05-01 02:00:00-04', 12, 17, 24.07);
INSERT INTO customerreferral VALUES (8, '2023-07-27 02:00:00-04', 20, 2, 16.71);
INSERT INTO customerreferral VALUES (9, '2023-05-17 02:00:00-04', 20, 3, 11.11);
INSERT INTO customerreferral VALUES (10, '2023-06-25 02:00:00-04', 20, 10, 14.04);
INSERT INTO customerreferral VALUES (11, '2023-04-26 02:00:00-04', 20, 9, 22.19);


-- SalesRep
INSERT INTO salesrep VALUES (1, 'Sally', 'McNabe', 0.25);
INSERT INTO salesrep VALUES (2, 'Jonas', 'Monthar', 0.15);
INSERT INTO salesrep VALUES (3, 'Holly', 'Brunet', 0.20);
INSERT INTO salesrep VALUES (4, 'Jennifer', 'Gardiner', 0.30);
INSERT INTO salesrep VALUES (5, 'Thomas', 'Bergen', 0.10);
INSERT INTO salesrep VALUES (6, 'Solance', 'Garcia', 0.05);
INSERT INTO salesrep VALUES (7, 'Brendon', 'McNabb', 0.20);

-- ServiceItem
INSERT INTO serviceitem VALUES ('1', 'Standard Cleaning', 'Hour', 22, 'General Cleaning Services');
INSERT INTO serviceitem VALUES ('2', 'Room Cleaning', 'Room', 125, 'General Cleaning Services');
INSERT INTO serviceitem VALUES ('3', 'Area Cleaning', 'Square Foot', 0.25, 'General Cleaning Services');
INSERT INTO serviceitem VALUES ('4', 'Kitchen Organization', 'Per Service', 120, 'Organizing Services');
INSERT INTO serviceitem VALUES ('5', 'Linen Organizing', 'Per Service', 180, 'Organizing Services');
INSERT INTO serviceitem VALUES ('6', 'High Dusting', 'Hour', 18, 'General Cleaning Services');
INSERT INTO serviceitem VALUES ('7', 'Carpet Cleaning', 'Square Foot', 0.4, 'Flooring and Furniture Cleaning');
INSERT INTO serviceitem VALUES ('8', 'Hardwood Steam Clean', 'Square Foot', 0.35, 'Flooring and Furniture Cleaning');
INSERT INTO serviceitem VALUES ('9', 'Dining Chair Steam Clean', 'Per Chair', 30, 'Flooring and Furniture Cleaning');
INSERT INTO serviceitem VALUES ('10', 'Loveseat Steam Clean', 'Per Sofa', 80, 'Flooring and Furniture Cleaning');
INSERT INTO serviceitem VALUES ('11', 'Sofa Steam Clean', 'Per Sofa', 140, 'Flooring and Furniture Cleaning');
INSERT INTO serviceitem VALUES ('12', 'Lounge Chair Steam Clean', 'Per Chair', 40, 'Flooring and Furniture Cleaning');



