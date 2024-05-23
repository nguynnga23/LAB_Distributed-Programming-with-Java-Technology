
GO
INSERT INTO [dbo].[Department]([id], [location], [name])
VALUES
    ('d1','New York City', 'Cardiology'),
    ('d2', 'Los Angeles', 'Dermatology'),
    ('d3', 'Chicago', 'Neurology');
GO

GO
INSERT INTO [dbo].[Doctor] (id, name, phone, speciality)
VALUES
    ('doc1', 'Dr. John Smith', '(555) 555-1212', 'Cardiology'),
    ('doc2', 'Dr. Jane Doe', '(444) 444-3333', 'Dermatology'),
    ('doc3', 'Dr. Michael Lee', '(333) 333-2222', 'Neurology');
GO

GO
-- Thêm dữ liệu mẫu vào bảng Patient
INSERT INTO [dbo].[Patient]
           ([id]
           ,[name]
           ,[phone]
           ,[address]
           ,[dateOfBirth]
           ,[gender])
     VALUES
           ('000-00-0001', 'Nguyễn Văn A', '0987654321', '123 Đường ABC, Quận XYZ, TP HCM', '1990-05-15', 'Nam'),
           ('000-00-0002', 'Trần Thị B', '0123456789', '456 Phố XYZ, Quận ABC, Hà Nội', '1985-10-20', 'Nữ'),
           ('000-00-0003', 'Lê Văn C', '0369852147', '789 Làng MNP, Huyện DEF, Đà Nẵng', '2000-12-03', 'Nam'),
           ('000-00-0004', 'Phạm Thị D', '0999999999', '321 Ngõ GHI, Quận JKL, Hải Phòng', '1978-03-25', 'Nữ'),
		   ('000-00-0005', 'Hoàng Văn E', '0987123456', '456 Đường MNO, Quận RST, TP HCM', '1993-08-12', 'Nam'),
           ('000-00-0006', 'Nguyễn Thị F', '0987654321', '789 Phố UVW, Quận XYZ, Hà Nội', '1987-11-17', 'Nữ'),
           ('000-00-0007', 'Trần Văn G', '0369852147', '012 Làng XYZ, Huyện ABC, Đà Nẵng', '2002-06-09', 'Nam'),
           ('000-00-0008', 'Lê Thị H', '0999999999', '123 Ngõ KLM, Quận NOP, Hải Phòng', '1975-09-28', 'Nữ'),
           ('000-00-0009', 'Phạm Văn I', '0987123456', '456 Đường PQR, Quận STU, TP HCM', '1991-04-30', 'Nam'),
           ('000-00-0010', 'Hoàng Thị J', '0987654321', '789 Phố STU, Quận VWX, Hà Nội', '1988-01-05', 'Nữ'),
           ('000-00-0011', 'Nguyễn Văn K', '0369852147', '012 Làng XYZ, Huyện DEF, Đà Nẵng', '2004-03-14', 'Nam'),
           ('000-00-0012', 'Trần Thị L', '0999999999', '123 Ngõ GHI, Quận JKL, Hải Phòng', '1979-07-23', 'Nữ'),
           ('000-00-0013', 'Lê Văn M', '0987123456', '456 Đường MNO, Quận RST, TP HCM', '1994-10-08', 'Nam'),
           ('000-00-0014', 'Phạm Thị N', '0987654321', '789 Phố UVW, Quận XYZ, Hà Nội', '1986-12-19', 'Nữ'),
           ('000-00-0015', 'Hoàng Văn O', '0369852147', '012 Làng XYZ, Huyện ABC, Đà Nẵng', '2001-02-27', 'Nam'),
           ('000-00-0016', 'Nguyễn Thị P', '0999999999', '123 Ngõ KLM, Quận NOP, Hải Phòng', '1974-05-16', 'Nữ'),
           ('000-00-0017', 'Trần Văn Q', '0987123456', '456 Đường PQR, Quận STU, TP HCM', '1992-09-03', 'Nam'),
           ('000-00-0018', 'Lê Thị R', '0987654321', '789 Phố STU, Quận VWX, Hà Nội', '1989-11-26', 'Nữ'),
           ('000-00-0019', 'Phạm Văn S', '0369852147', '012 Làng XYZ, Huyện DEF, Đà Nẵng', '2003-04-07', 'Nam'),
           ('000-00-0020', 'Hoàng Thị T', '0999999999', '123 Ngõ GHI, Quận JKL, Hải Phòng', '1977-08-14', 'Nữ');
GO



GO
-- Thêm dữ liệu mẫu vào bảng Treatment
INSERT INTO [dbo].[Treatment]
           ([diagnosis]
           ,[endDate]
           ,[startDate]
           ,[patient_id]
           ,[department_id]
           ,[doctor_id])
     VALUES
           ('Cold', '2024-04-10', '2024-04-05', '000-00-0001', 'd1', 'doc1'),
           ('Fractured leg', '2024-04-12', '2024-04-07', '000-00-0002', 'd2', 'doc2'),
           ('Headache', '2024-04-09', '2024-04-04', '000-00-0003', 'd3', 'doc3'),
           ('Stomachache', '2024-04-11', '2024-04-06', '000-00-0004', 'd1', 'doc3'),
           ('Fever', '2024-04-08', '2024-04-03', '000-00-0005', 'd2', 'doc3'),
           ('Injury', '2024-04-13', '2024-04-08', '000-00-0006', 'd3', 'doc3'),
           ('Migraine', '2024-04-14', '2024-04-09', '000-00-0007', 'd1', 'doc3'),
           ('Allergy', '2024-04-15', '2024-04-10', '000-00-0009', 'd2', 'doc3'),
           ('Back pain', '2024-04-16', '2024-04-11', '000-00-0010', 'd3', 'doc1'),
           ('Pneumonia', '2024-04-17', '2024-04-12', '000-00-0011', 'd1', 'doc1'),
           ('Flu', '2024-04-18', '2024-04-13', '000-00-0012', 'd2', 'doc2'),
           ('Sore throat', '2024-04-19', '2024-04-14', '000-00-0013', 'd3', 'doc3'),
           ('Anxiety', '2024-04-20', '2024-04-15', '000-00-0014', 'd1', 'doc3'),
           ('Depression', '2024-04-21', '2024-04-16', '000-00-0015', 'd2', 'doc1'),
           ('High blood pressure', '2024-04-22', '2024-04-17', '000-00-0016', 'd3', 'doc1'),
           ('Diabetes', '2024-04-23', '2024-04-18', '000-00-0017', 'd1', 'doc1'),
           ('Arthritis', '2024-04-24', '2024-04-19', '000-00-0018', 'd2', 'doc1'),
           ('Asthma', '2024-04-25', '2024-04-20', '000-00-0019', 'd3', 'doc1'),
           ('Kidney stones', '2024-04-26', '2024-04-21', '000-00-0020', 'd1', 'doc1');
GO
