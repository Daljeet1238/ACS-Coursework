-- ACS-3902 Assignment 2 Part B
-- Name: Daljeet Singh
-- St#: 3169763
--------------------------------
SET SCHEMA 'daljeet_3169763_as2_a_b';  


-- Part B2:  Creating FK Constraints with RI Actions
-----------------------------------------------------------------------------

-- Dropping the previous created foreign keys
ALTER TABLE cleaninginvoiceitem
DROP CONSTRAINT IF EXISTS fk_serviceitemid;

ALTER TABLE cleaninginvoiceitem
DROP CONSTRAINT IF EXISTS pk_cleaninginvoiceitem;

-- creating the foreign key constraints woth appropriate referential integrity
ALTER TABLE customer
ADD CONSTRAINT fk_salesrepnumber
FOREIGN KEY (salesrepnumber) REFERENCES salesrep(salesrepnumber)
ON UPDATE CASCADE
ON DELETE SET NULL;

ALTER TABLE customerreferral 
ADD CONSTRAINT fk_referring_customer
FOREIGN KEY (referringcustomer) REFERENCES customer(customerid)
ON UPDATE CASCADE
ON DELETE RESTRICT;

ALTER TABLE customerreferral 
ADD CONSTRAINT fk_referred_customer
FOREIGN KEY (referredcustomer) REFERENCES customer(customerid)
ON UPDATE CASCADE
ON DELETE RESTRICT;

ALTER TABLE cleaninginvoice
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customerid) REFERENCES customer(customerid)
ON UPDATE CASCADE
ON DELETE RESTRICT;

ALTER TABLE cleaninginvoice
ADD CONSTRAINT fk_booking_source_id
FOREIGN KEY (bookingsourceid) REFERENCES bookingsource(bookingsourceid)
ON UPDATE CASCADE
ON DELETE RESTRICT;

ALTER TABLE cleaninginvoiceitem
ADD CONSTRAINT fk_cleaning_invoice_number
FOREIGN KEY (cleaninginvoicenumber) REFERENCES cleaninginvoice(cleaninginvoicenumber)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE cleaninginvoiceitem
ADD CONSTRAINT fk_service_item_id
FOREIGN KEY (serviceitemid) REFERENCES serviceitem(serviceitemid)
ON UPDATE CASCADE
ON DELETE RESTRICT;