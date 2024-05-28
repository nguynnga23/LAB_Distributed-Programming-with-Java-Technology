package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.impl.DoctorImpl;
import entity.Doctor;
import entity.Treatment;

/**
 * @author Nguyen Thi Nga
 * @date May 23, 2024
 */
class DoctorDaoTest {
	private DoctorDao doctorDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		doctorDao = new DoctorImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		doctorDao = null;
	}

	@Test
	void testGetNoTreatmentsByDoctors() {
		List<Doctor> list = (List<Doctor>) doctorDao.getDoctorsByDepartment("Cardiology");
		assertEquals(2, list.size());
		assertNotNull(list);
		for (Doctor doctor : list) {
			Set<Treatment> treatments = (Set<Treatment>) doctor.getTreatments();
			for (Treatment treatment : treatments) {
				assertEquals("Cardiology", treatment.getDepartment().getName());
			}
			
		}
	}

}
