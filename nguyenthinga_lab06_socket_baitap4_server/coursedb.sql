USE [coursedb]

--INSERT SAMPLE DATABASE
--Department
GO
INSERT INTO [dbo].[Department] ([DepartmentID],[Administrator],[Budget],[Name],[StartDate]) VALUES(1, 1, 100.0, 'Computer Science', '2023-12-01 00:00:00.000000')
INSERT INTO [dbo].[Department] ([DepartmentID],[Administrator],[Budget],[Name],[StartDate]) VALUES(2, 2, 200.0, 'Mathemagics', '2023-12-02 00:00:00.000000')
INSERT INTO [dbo].[Department] ([DepartmentID],[Administrator],[Budget],[Name],[StartDate]) VALUES(3, 3, 300.0, 'Electrical Engineering', '2023-12-03 00:00:00.000000')
INSERT INTO [dbo].[Department] ([DepartmentID],[Administrator],[Budget],[Name],[StartDate]) VALUES(4, 4, 400.0, 'Industrial Engineering', '2023-12-04 00:00:00.000000')
INSERT INTO [dbo].[Department] ([DepartmentID],[Administrator],[Budget],[Name],[StartDate]) VALUES(5, 5, 500.0, 'Musicology', '2023-12-05 00:00:00.000000')
GO

--Course
GO
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(1, 111, 'Programming', 1)
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(2, 222, 'Algorithms', 2)
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(3, 333, 'Systems', 3)
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(4, 444, 'Algebra', 4)
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(5, 555, 'Calculus', 5)
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(6, 555, 'Analysis', 5)
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(7, 555, 'Jazz', 5)
INSERT INTO [dbo].[Course]([CourseID], [Credits], [Title], [DepartmentID]) VALUES(9, 555, 'Circuits', 5)
GO

--OnlineCourse
GO
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,1)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,2)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,3)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,4)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,5)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,6)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,7)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,8)
INSERT INTO [dbo].[OnlineCourse]([URL], [CourseID]) VALUES ('https://www.w3schools.com/sql/sql_datatypes.asp' ,9)
GO

--OnsiteCourse
GO
INSERT INTO [dbo].[OnsiteCourse] ([Days], [Location], [Time], [CourseID])
VALUES ('MWF', 'Room 101', '10:00:00.000', 1),
       ('TTh', 'Library Conference Room', '13:30:00.000', 2),
	   ('TTh', 'Library Conference Room', '13:30:00.000', 3);
GO

--[dbo].[OfficeAssignment]
GO
INSERT INTO [dbo].[OfficeAssignment] ([Location], [Timestamp], [InstructorID])
VALUES ('Main Building', '2024-03-31 10:00:00.000000', 1),
       ('Library', '2024-03-29 14:30:00.000000', 2);
GO

--[dbo].[Person]
INSERT INTO [dbo].[Person] ([Discriminator], [FirstName], [LastName], [HireDate], [EnrollmentDate])
VALUES ('Student', 'Nguyễn', 'Văn A', NULL, '2023-09-01 00:00:00.000000');
INSERT INTO [dbo].[Person] ([Discriminator], [FirstName], [LastName], [HireDate], [EnrollmentDate])
VALUES ('Student', 'Trần', 'Thị B', NULL, '2023-10-15 00:00:00.000000');
INSERT INTO [dbo].[Person] ([Discriminator], [FirstName], [LastName], [HireDate], [EnrollmentDate])
VALUES ('Student', 'Lê', 'Văn C', NULL, '2023-11-01 00:00:00.000000');

INSERT INTO [dbo].[Person] ([Discriminator], [FirstName], [LastName], [HireDate], [EnrollmentDate])
VALUES ('Instructor', 'Phạm', 'Minh D', '2022-01-10 09:00:00.000000', NULL);
INSERT INTO [dbo].[Person] ([Discriminator], [FirstName], [LastName], [HireDate], [EnrollmentDate])
VALUES ('Instructor', 'Đặng', 'Thị E', '2021-05-15 09:00:00.000000', NULL);
INSERT INTO [dbo].[Person] ([Discriminator], [FirstName], [LastName], [HireDate], [EnrollmentDate])
VALUES ('Instructor', 'Vũ', 'Văn F', '2020-12-01 09:00:00.000000', NULL);

--[dbo].[CourseInstructor]
GO
INSERT INTO [dbo].[CourseInstructor] ([CourseID], [InstructorID])
VALUES
  (1, 2), 
  (3, 1),
  (4, 2)
GO

--[dbo].[StudentGrade]
GO
INSERT INTO [dbo].[StudentGrade] ([EnrollmentID], [Grade], [CourseID], [StudentID])
VALUES
  (1, 3.8, 2, 3), 
  (2, 2.5, 1, 1)   
GO




