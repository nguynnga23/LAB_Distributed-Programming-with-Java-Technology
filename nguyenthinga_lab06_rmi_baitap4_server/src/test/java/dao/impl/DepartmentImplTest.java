package dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Mar 31, 2024
 */
class DepartmentImplTest {
	private DepartmentImpl departmentImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		departmentImpl = new DepartmentImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		departmentImpl.close();
	}

	@Test
	void testFindDepartmentById() throws RemoteException {
//		departmentDao = new DepartmentDao(em);
		Department department = departmentImpl.findById(1);
		System.err.println(department);
		assertNotNull(departmentImpl.findById(1));
		assertNull(departmentImpl.findById(100));
	}

//	@Test
//	void testAddDepartment() {
//		Department department = new Department(1, 1000, "Khoa CNTT", LocalDateTime.now());
//		departmentImpl.addDepartment(department);
//		assertNotNull(departmentImpl.findById(department.getId()));
//	}
//
//	@Test
//	void testUpdateDepartment() {
//		Department department = departmentImpl.findById(1);
//		department.setName("Khoa CNTT - updated");
//		departmentImpl.updateDepartment(department);
//		assertEquals("Khoa CNTT - updated", departmentImpl.findById(1).getName());
//
//	}
	@Test
	void testFinddByName() throws RemoteException {
		List<Department> departments = departmentImpl.findByName("K");
		for (Department department : departments) {
			System.err.println(department);
		}
	}

//	@Test
//	void testDeleteDepartment() {
//		departmentImpl.deleteDepartment(1);
//		try {
//			assertNull(departmentImpl.findById(1));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
//	@Test
//	void testFindAll() {
//		List<Department> departments = departmentImpl.findAll();
//		for (Department department : departments) {
//			System.err.println(department);
//		}
//	}
	
	

}
