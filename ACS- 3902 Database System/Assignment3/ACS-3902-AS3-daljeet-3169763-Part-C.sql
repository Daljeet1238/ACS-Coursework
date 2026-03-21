-- ACS-3902 Assignment 3 Part C
-- Name: Daljeet Singh
-- St#: 3169763
--------------------------------
CREATE SCHEMA daljeet_3169763_as3_c;

SET SCHEMA 'daljeet_3169763_as3_c';


-- Table and Constraint Declarations
-----------------------------------------------------------------------------

-- User
CREATE TABLE UserTable (
    UserId varchar(100) PRIMARY KEY,
    Email varchar(255) NOT NULL UNIQUE,
    FirstName varchar(100) NOT NULL,
    LastName varchar(100) NOT NULL
);

-- Renter
CREATE TABLE Renter (
	UserId varchar(100) PRIMARY KEY,
	payoutInterval varchar(100) NOT NULL,
	PayoutPreference varchar(100) NOT NULL,

	CONSTRAINT fk_UserId FOREIGN KEY (UserId) REFERENCES UserTable(UserId)
);

-- Lesee
CREATE TABLE Lesee (
	UserId varchar(100) PRIMARY KEY,
	
	FOREIGN KEY (UserId) REFERENCES UserTable(UserId)
);

-- Payment Method
CREATE TABLE PaymentMethod (
	PaymentMethodId integer PRIMARY KEY,
	UserId varchar(100),

	CONSTRAINT fk_payment_method FOREIGN KEY (UserId) REFERENCES UserTable(UserId)
);

-- eTransfer
CREATE TABLE eTransfer (
	PaymentMethodId integer PRIMARY KEY,
	AccountNumber varchar(100) NOT NULL,
	InstitutionNumber varchar(100) NOT NULL,
	TransitNumber varchar(100) NOT NULL,

	FOREIGN KEY (PaymentMethodId) REFERENCES PaymentMethod(PaymentMethodId)
);

-- Credit Card
CREATE TABLE CreditCard (
	PaymentMethodId integer PRIMARY KEY,
	CardNumber varchar(100) NOT NULL,
	ExpiryDate varchar(15) NOT NULL,
	CVC varchar(3) NOT NULL,

	FOREIGN KEY (PaymentMethodId) REFERENCES PaymentMethod(PaymentMethodId)	
);


--Item
CREATE TABLE Item (
	ItemNumber integer PRIMARY KEY,
	ItemName varchar(100) NOT NULL,
	ItemDescription text,
	UserId varchar(100) NOT NULL,
	ItemType varchar(100) NOT NULL,

	FOREIGN KEY (UserId) REFERENCES UserTable(UserId),
	CHECK (ItemType IN ('Tool', 'Electronics'))
);


-- Rental Agreement
CREATE TABLE RentalAgreement (
	AgreementNumber integer PRIMARY KEY,
	RentalDate date NOT NULL,
	RenterId varchar(100) NOT NULL,
	LeseeId varchar(100) NOT NULL,

	FOREIGN KEY (RenterId) REFERENCES Renter(UserId),
	FOREIGN KEY (LeseeId) REFERENCES Lesee(UserId)
);

-- Rented Item
CREATE TABLE RentedItem (
	AgreementNumber integer NOT NULL,
	ItemNumber integer NOT NULL,
	DaysRented integer NOT NULL,
	RentalFeeCharge decimal(10,2) NOT NULL,

	PRIMARY KEY(AgreementNumber, ItemNumber),
	FOREIGN KEY (AgreementNumber) REFERENCES RentalAgreement(AgreementNumber),
	FOREIGN KEY (ItemNumber) REFERENCES Item(ItemNumber)
);

--Payment
CREATE TABLE Payment (
	PaymentNumber integer PRIMARY KEY,
	PaymentDate date NOT NULL,
	PaymentAmount decimal(10,2) NOT NULL,
	AgreementNumber integer NOT NULL,
	LeseeId varchar(100) NOT NULL,
	PaymentMethodId integer NOT NULL,

	FOREIGN KEY (AgreementNumber) REFERENCES RentalAgreement(AgreementNumber),
	FOREIGN KEY (LeseeId) REFERENCES Lesee(UserId),
	FOREIGN KEY (PaymentMethodId) REFERENCES PaymentMethod(PaymentMethodId)
);

-- Data Insert Statements
-----------------------------------------------------------------------------

INSERT INTO UserTable VALUES ('cjoyal', 'Claude.Joyal@gmail.com', 'Claude', 'Joyal'),
						('srobins', 'selina.robins@hotmail.com', 'Selina', 'Robins');
			

INSERT INTO Renter VALUES ('cjoyal', 'Monthly', 'Cheque'),
					('srobins', 'Weekly', 'Direct Deposit');

INSERT INTO Lesee VALUES ('srobins'),
					('cjoyal');

INSERT INTO PaymentMethod VALUES (87, 'cjoyal'),
						(88, 'cjoyal'),
						(65, 'srobins');

INSERT INTO eTransfer VALUES (87, '10005007', '097', '50198'),
						(65, '10889746', '003', '84752');

INSERT INTO CreditCard VALUES (88, '45000080000581163', '2024-09', '887');

INSERT INTO Payment VALUES (8899, '2024-02-14', 80.50, 7465, 'srobins', 87);

INSERT INTO RentalAgreement VALUES (7465, '2024-02-13', 'cjoyal', 'srobins');

INSERT INTO Item VALUES (1348, 'PS5', 'Playstation5', 'cjoyal', 'Electronics'),
					(1349, 'Cordless Drill', '9V Dewalt', 'cjoyal', 'Tool');

INSERT INTO RentedItem VALUES (7465, 1348, 1, 40.50),
						(7465, 1349, 1, 40.00);












