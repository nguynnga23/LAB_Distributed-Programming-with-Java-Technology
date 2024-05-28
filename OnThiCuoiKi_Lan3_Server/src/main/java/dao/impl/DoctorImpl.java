package dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.DoctorDao;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public class DoctorImpl implements DoctorDao {
	private EntityManager em;

	public DoctorImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan3_Server");
		em = emf.createEntityManager();
	}

//	--c.(1.5 điểm) Thống kê số lượt điều trị bệnh của các bác sĩ theo tháng / năm (dựa vào
//			--ngày bắt đầu). Sắp xếp theo chuyên môn của bác sĩ.
//			--+ getNoTreatmentsByDoctors (int month, int year) : Map<Doctor, Integer>

	@Override
	public Map<Doctor, Long> getNoTreatmentsByDoctors(int month, int year) {
		// Viết bằng câu query SQL
		String query = "SELECT d, COUNT(t) FROM Doctor d JOIN d.treatments t WHERE MONTH(t.startDate) = :month AND YEAR(t.startDate) = :year GROUP BY d ORDER BY d.speciality";
		Map<Doctor, Long> result = new LinkedHashMap<Doctor, Long>();
		List<?> list = em.createQuery(query).setParameter("month", month).setParameter("year", year).getResultList();
		list.stream().map(e -> (Object[]) e).forEach(e -> result.put((Doctor) e[0], (Long) e[1]));
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorsByDepartment(String deptName) {
		String query = "SELECT DISTINCT doc.* " + "FROM Treatment t " + "JOIN Doctor doc ON doc.id = t.doctor_id "
				+ "JOIN Department d ON d.id = t.department_id " + "WHERE d.name LIKE ?";

		return em.createNativeQuery(query, Doctor.class).setParameter(1, "%" + deptName + "%").getResultList();
	}
	

	public static void main(String[] args) {
		DoctorImpl doctorImpl = new DoctorImpl();
		Map<Doctor, Long> result = doctorImpl.getNoTreatmentsByDoctors(4, 2024);
		result.forEach((k, v) -> System.out.println(k + " " + v));

		List<Doctor> doctors = doctorImpl.getDoctorsByDepartment("Cardiology");
		for (Doctor doctor : doctors) {
			System.out.println(doctor);
		}
	}

}
