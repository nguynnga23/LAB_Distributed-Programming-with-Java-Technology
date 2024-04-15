package dao.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.startsWith;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.StudentDao;
import entity.Student;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
class StudentImplTest {
	
	private StudentDao studentDao;
	

	@BeforeEach
	void setUp() throws Exception {
		studentDao = new StudentImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		studentDao.close();
	}

	@Test
	void testFindByEnrollmentInYear() throws RemoteException {
		System.err.println("testFindByEnrollmentInYear");
		List<Student> students = studentDao.findByEnrollmentInYear(2005);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	void testFindByEnrollmentInCourse() throws RemoteException {
		System.err.println("testFindByEnrollmentInCourse");
		List<Student> students = studentDao.findByEnrollmentInCourse("Chemistry");
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
