package dao.impl;

import static org.junit.Assert.assertTrue;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.PatientDao;
import entity.Patient;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
class PatientImplTest {
	private PatientDao patientDao;
	@BeforeEach
	void setUp() throws Exception {
		patientDao = (PatientDao) Naming.lookup("rmi://localhost:1791/patientDao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddPatient() throws RemoteException {
//		Patient(String id, String name, String phone,String gender, String address, LocalDate dateOfBirth)
	    Patient patient = new Patient("P21", "Nguyễn Thị Nga", "0987654321", "Nữ", "Hà Nội", LocalDate.now());
		assertTrue(patientDao.addPatient(patient));
	}

}
