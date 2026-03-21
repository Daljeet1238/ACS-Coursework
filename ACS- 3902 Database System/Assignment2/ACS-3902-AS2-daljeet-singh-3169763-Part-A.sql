-- ACS-3902 Assignment 2 Part A
-- Name: Daljeet Singh
-- St#: 3169763
--------------------------------
SET SCHEMA 'daljeet_3169763_as2_a_b';


-- Part A.1: Correcting Duplicate Data in the Cleaning Invoice Detail Table
-----------------------------------------------------------------------------
-- Question A.1.1
SELECT *
FROM cleaninginvoiceitem
WHERE (cleaninginvoicenumber, invoicelineitemnumber) IN (
    SELECT cleaninginvoicenumber, invoicelineitemnumber
    FROM cleaninginvoiceitem
    GROUP BY cleaninginvoicenumber, invoicelineitemnumber
    HAVING COUNT(*) > 1
);

-- Question A.1.2

UPDATE cleaninginvoiceitem
SET invoicelineitemnumber = 2
WHERE cleaninginvoicenumber = 4 AND invoicelineitemnumber = 1 AND serviceitemid = '3';

UPDATE cleaninginvoiceitem
SET invoicelineitemnumber = 3
WHERE cleaninginvoicenumber = 4 AND invoicelineitemnumber = 1 AND serviceitemid = '9';

UPDATE cleaninginvoiceitem
SET invoicelineitemnumber = 3
WHERE cleaninginvoicenumber = 6 AND invoicelineitemnumber = 2 AND serviceitemid = '6';

UPDATE cleaninginvoiceitem
SET invoicelineitemnumber = 4
WHERE cleaninginvoicenumber = 6 AND invoicelineitemnumber = 2 AND serviceitemid = '3';

UPDATE cleaninginvoiceitem
SET invoicelineitemnumber = 5
WHERE cleaninginvoicenumber = 6 AND invoicelineitemnumber = 2 AND serviceitemid = '1';

ALTER TABLE cleaninginvoiceitem 
ADD CONSTRAINT pk_cleaninginvoiceitem PRIMARY KEY (cleaninginvoicenumber, invoicelineitemnumber);


-- Part A.2: A.2 Correcting Service Item Codes
-----------------------------------------------------------------------------
-- Question A.2.1
--
SELECT c.customerid, c.businessname, c.lastname, ci.cleaninginvoicenumber as invoiceid, ci.bookingdate, cii.invoicelineitemnumber, s.serviceitemid
FROM cleaninginvoice ci
JOIN customer c ON ci.customerid = c.customerid
JOIN cleaninginvoiceitem cii ON ci.cleaninginvoicenumber = cii.cleaninginvoicenumber
LEFT OUTER JOIN serviceitem s ON cii.serviceitemid = s.serviceitemid
WHERE s.serviceitemid IS NULL
ORDER BY c.customerid, ci.bookingdate;

-- Question A2.2

-- correct service item codes
UPDATE cleaninginvoiceitem
SET serviceitemid = '5'
WHERE serviceitemid = '05';

UPDATE cleaninginvoiceitem
SET serviceitemid = '1'
WHERE serviceitemid = '01';

UPDATE cleaninginvoiceitem
SET serviceitemid = '6'
WHERE serviceitemid = '06';

UPDATE cleaninginvoiceitem
SET serviceitemid = 'UK'
WHERE serviceitemid IS NULL;

INSERT INTO serviceitem VALUES ('OT', 'Other Services', 'Hour', 20, 'Other');

INSERT INTO serviceitem VALUES ('UK', 'Unknown', 'Unknown', 1, 'Other');

ALTER TABLE cleaninginvoiceitem
ADD CONSTRAINT fk_serviceitemid FOREIGN KEY (serviceitemid) REFERENCES serviceitem(serviceitemid);

-- Part A.3 Merging Duplicate Customer Records
-----------------------------------------------------------------------------

-- Question A.3.1 
SELECT c1.customerid, c1.customertype, c1.businessname, c1.firstname, c1.lastname, c1.address, c1.email
FROM customer c1
JOIN customer c2 ON (c1.email = c2.email)
					OR (c1.firstname = c2.firstname AND c1.lastname = c2.lastname)
					OR (c1.address = c2.address)
WHERE c1.customerid <> c2.customerid
ORDER BY c1.customerid

-- Question A.3.2
UPDATE cleaninginvoice
SET customerid = 10
WHERE customerid = 11;

UPDATE customerreferral
SET referringcustomer  = 10
WHERE referringcustomer = 11;


UPDATE customerreferral
SET referredcustomer  = 10
WHERE referredcustomer = 11;

-- Deleting the duplicate customer
DELETE FROM customer
WHERE customerid = 11;

-- Question A.3.3
ALTER TABLE customer
ADD CONSTRAINT unique_customer UNIQUE(email, customertype, firstname, lastname, postalcode);
