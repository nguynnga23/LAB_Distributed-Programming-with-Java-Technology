--a.(1.5 điểm) Thêm mới một bệnh nhân. Trong đó, mã bệnh nhân luôn gồm 9 ký số và theo mấu "000-00-0000".
--+ addPatient (patient: Patient) : boolean
--b.(1.5 điểm) Tìm kiếm danh sách các bác sỹ đã từng điều trị cho bệnh nhân ở một khoa
--nào đó khi biết tên khoa.
--+ getDoctorsByDepartment(deptName: String): List<Doctor>
SELECT DISTINCT doc.*
FROM Treatment t
JOIN Doctor doc ON doc.id = t.doctor_id
JOIN Department d ON d.id = t.department_id
WHERE d.name LIKE '%Cardiology%'
--c.(1.5 điểm) Thống kê số lượt điều trị bệnh của các bác sĩ theo tháng / năm (dựa vào
--ngày bắt đầu). Sắp xếp theo chuyên môn của bác sĩ.
--+ getNoTreatmentsByDoctors (int month, int year) : Map<Doctor, Integer>
SELECT * FROM  Treatment