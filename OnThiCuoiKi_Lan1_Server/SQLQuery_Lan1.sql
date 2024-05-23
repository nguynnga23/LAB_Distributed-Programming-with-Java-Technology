
--a) Liệt kê danh sách các vị trí công việc khi biết tên vị trí (tìm tương đối) và mức lương khoảng từ, kết quả sắp xếp theo tên vị trí công việc. 
--+ listPositions(name: String, salaryFrom: double, salaryTo: double): List<Position> 

SELECT * FROM positions p
WHERE p.name LIKE '%S%' -- Replace <search_term> with the actual search term
      AND p.salary >= 11000 -- Replace <min_salary> with the minimum salary
      AND p.salary <= 15000 -- Replace <max_salary> with the maximum salary
ORDER BY p.name;

--b) Liệt kê danh sách các ứng viên và số công ty mà các ứng viên này từng làm.
--+ listCadidatesByCompanies() : Map<Candidate, Long> 

SELECT c.candidate_id, COUNT(e.company_name) AS n
FROM experiences e
JOIN candidates c ON e.candidate_id = c.candidate_id
GROUP BY c.candidate_id
ORDER BY n;

--c) Tìm danh sách các ứng viên đã làm việc trên một vị trí công việc nào đó có thời gian làm lâu nhất. 
--+ listCandidatesWithLongestWorking (): Map<Candidate, Position> 

WITH WorkDurations AS(
	SELECT *, DATEDIFF(YEAR, e.from_date, e.to_date) AS duration
	FROM experiences e
),
MaxDurations AS(
	SELECT MAX(wd.duration) AS max_duration
	FROM WorkDurations wd
)

SELECT wd.candidate_id, wd.position_id, md.max_duration
FROM WorkDurations wd, MaxDurations md
WHERE wd.duration = md.max_duration




--d) Thêm một ứng viên mới. Trong đó mã số ứng viên phải bắt đầu là C, theo sau ít nhất là 3 ký số. 
--+ addCandidate(candidate: Candidate) : boolean 

ALTER TABLE [dbo].[candidates]
ADD CONSTRAINT chk_CandidateID CHECK (candidate_id LIKE 'C[0-9][0-9][0-9]%');

INSERT INTO [dbo].[candidates]
           ([candidate_id]
           ,[description]
           ,[email]
           ,[full_name]
           ,[gender]
           ,[phone]
           ,[year_of_birth]
           ,[position_id])
     VALUES
           ('C011',
           'Software Engineer. 10 years of experience in software development (Java C++ Python). Strong problem-solving skills team player good English communication skills. . Weakness in sports and outdoor activities.',
           'john.doe@gmail.com',
           'John Doe',
           'Male',
           '123-456-7890',
           '1980',
           'P101')
GO



--e) Tính số năm làm việc trên một vị trí công việc nào đó khi biết mã số ứng viên. 
--+ listYearsOfExperienceByPosition(candidateID: String): Map<Position, Integer> 

SELECT e.position_id, e.candidate_id, DATEDIFF(YEAR, e.from_date, e.to_date) AS duration
FROM experiences e
WHERE e.candidate_id = 'C102'

--f) Liệt kê danh sách các ứng viên và danh sách bằng cấp của từng ứng viên.
--+ listCadidatesAndCertificates(): Map<Candidate, Set<Certificate >> 

SELECT 
    c.candidate_id, 
    c.full_name, 
    ct.certificate_id, 
    ct.name
FROM 
    candidates c
LEFT JOIN 
    certificates ct ON c.candidate_id = ct.candidate_id;


