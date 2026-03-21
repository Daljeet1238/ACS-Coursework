-- ACS-3902 Assignment 4 Part B
-- Name: Daljeet Singh
-- St#: 3169763
--------------------------------
CREATE SCHEMA daljeet_3169763_as4_part_b;

SET SCHEMA 'daljeet_3169763_as4_part_b';

-- School Table
CREATE TABLE School (
	SchoolID int PRIMARY KEY,
	Name varchar(100) NOT NULL,
	Location varchar(100)
);

-- Student Table
CREATE TABLE StudentTable (
	StudentID int PRIMARY KEY,
	StudentName varchar(100) NOT NULL,
	Age int,
	AgeGroup varchar(50),
	Email varchar(100) NOT NULL UNIQUE,
	Major varchar(100) NOT NULL,
	SchoolID int,

	FOREIGN KEY (SchoolID) REFERENCES School(SchoolID)
);

-- Group Table
CREATE TABLE GroupTable (
	GroupID int PRIMARY KEY,
	GroupName varchar(100) NOT NULL,
	Description Text,
	Category varchar(100),
	CreationDate Date,
	SchoolID int,

	FOREIGN KEY (SchoolID) REFERENCES School(SchoolID)
);

CREATE TABLE Hobbies(
	StudentID int,
	Hobbies text,

	FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);

--Insert into School 
INSERT INTO School VALUES (1, 'DAV School', 'Ludhiana'),
						(2, 'Bright School', 'Winnipeg');

-- Insert into StudentTable
INSERT INTO StudentTable VALUES (1, 'Ab de Villiers', 21 , '18-21', 'abde@gmail.com', 'Business', 1),
							(2, 'Bazz' , 25, '22-25', 'bazz@gmail.com', 'Computer Science',2),
							(3, 'Jack', 28, '26-29', 'jack@gmail.com', 'Agriculture',1),
							(4, 'Arjan Dhillon', 29, '26-29', 'brownstudio@gmail.com', 'Music',2),
							(5, 'Karan Aujla', 25, '22-25', 'rehan@gmail.com', 'Music',1);

-- Insert into GroupTable
INSERT INTO GroupTable VALUES (101, 'Cricket Enthusiasts', 'A group for cricket lovers', 'Sports', '2017-06-01',1),
    						(102, 'Music Lovers', 'A group for music enthusiasts', 'Music', '2019-05-15',2);

INSERT INTO Hobbies VALUES(1,'Cricket'),
						(1, 'Swimming'),
						(2, 'Music'),
						(2, 'Cricket'),
						(3, 'Sleeping'),
						(4, 'Writing'),
						(4, 'Riding'),
						(5, 'Writing')

