package dao.impl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map.Entry;

import javax.naming.NamingException;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.TreatmentDao;
import entity.Doctor;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
class TreatmentImplTest {
	private TreatmentDao treatmentDao;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws NamingException, RemoteException, MalformedURLException, NotBoundException  {
		treatmentDao = (TreatmentDao) Naming.lookup("rmi://localhost:1792/treatmentDao");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testgetNoTreatmentsByDoctors() throws NamingException, RemoteException, MalformedURLException, NotBoundException {
//		treatmentDao = (TreatmentDao) Naming.lookup("rmi://localhost:1792/treatmentDao");
		System.err.println("testgetNoTreatmentsByDoctors");
		Set<Entry<Doctor, Long>> map = treatmentDao.getNoTreatmentsByDoctors(4, 2024).entrySet();
		map.forEach(System.out::println);
	}
	
	@Test
	void testgetDoctorsByDepartmentReturnMap() throws RemoteException, MalformedURLException, NotBoundException {
		treatmentDao = (TreatmentDao) Naming.lookup("rmi://localhost:1792/treatmentDao");
		System.err.println("testgetDoctorsByDepartmentReturnMap");
		Set<Entry<Doctor, String>> map = treatmentDao.getDoctorsByDepartmentReturnMap("Cardiology").entrySet();
		map.forEach(System.out::println);
	}
	
	@Test 
	void testgetDoctorsByDepartmentReturnList() throws RemoteException, MalformedURLException, NotBoundException {
		treatmentDao = (TreatmentDao) Naming.lookup("rmi://localhost:1792/treatmentDao");
		System.err.println("testgetDoctorsByDepartmentReturnList");
		treatmentDao.getDoctorsByDepartmentReturnList("Cardiology").forEach(System.out::println);
	}

}
