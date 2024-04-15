package dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.rmi.RemoteException;
import java.util.Map.Entry;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Doctor;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
class TreatmentImplTest {
	private TreatmentImpl treatmentImpl;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		treatmentImpl = new TreatmentImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testgetNoTreatmentsByDoctors() throws RemoteException {
		System.err.println("testgetNoTreatmentsByDoctors");
		Set<Entry<Doctor, Long>> map = treatmentImpl.getNoTreatmentsByDoctors(4, 2024).entrySet();
		map.forEach(System.out::println);
	}
	
	@Test
	void testgetDoctorsByDepartmentReturnMap() throws RemoteException {
		System.err.println("testgetDoctorsByDepartmentReturnMap");
		Set<Entry<Doctor, String>> map = treatmentImpl.getDoctorsByDepartmentReturnMap("Cardiology").entrySet();
		map.forEach(System.out::println);
	}
	
	@Test 
	void testgetDoctorsByDepartmentReturnList() throws RemoteException {
		System.err.println("testgetDoctorsByDepartmentReturnList");
		treatmentImpl.getDoctorsByDepartmentReturnList("Cardiology").forEach(System.out::println);
	}

}
