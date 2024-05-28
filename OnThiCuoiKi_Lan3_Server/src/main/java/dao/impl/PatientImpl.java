package dao.impl;

import java.time.LocalDate;

import dao.PatientDao;
import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public class PatientImpl implements PatientDao {
	private EntityManager em;

	public PatientImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan3_Server");
		em = emf.createEntityManager();
	}
//	Thêm mới
//	một bệnh
//	nhân. Trong đó, mã
//	bệnh nhân
//	luôn gồm 9
//	ký số
//	và theo mấu"000-00-0000".

	@Override
	public boolean addPatient(Patient patient) {
		EntityTransaction tx = em.getTransaction();
		try {
			if (patient.getId().matches("\\d{3}-\\d{2}-\\d{4}")) {
				tx.begin();
				em.persist(patient);
				tx.commit();
				return true;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		PatientImpl patientImpl = new PatientImpl();
//		Patient(String id, String name, String phone, String gender, LocalDate dateOfBirth, String address)
		Patient patient = new Patient("001-1-0001", "Nga", "012345678", "F", LocalDate.of(2000, 1, 1), "Ha Noi");
		System.out.println(patientImpl.addPatient(patient));
	}

}
