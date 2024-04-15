package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Student;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
class StudentDaoTest {
	private static final String DB_NAME = "coursedb";
	private StudentDao studentDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		studentDao = new StudentDao(AppUtil.driverInit(), DB_NAME);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		studentDao.close();
		studentDao = null;
	}

//	@Test
//	void testAddStudent() {
//		Student st = new Student("77", "Smith", 3.6f);
//		String id = studentDao.addStudent(st);
//		String expected = "77";
//		String actual = id;
//		assertEquals(expected, actual);
//	}

//	@Test
//	void testFindStudentID() {
//		String id = "77";
//		Student st = studentDao.findStudentByID(id);
//		assertNotNull(st);
//		assertEquals("Smith", st.getName());
//		assertEquals(3.6f, st.getGpa());
//	}
//
//	@Test
//	void testFindStudentByID_Null() {
//		String id = "555";
//		Student st = studentDao.findStudentByID(id);
//		assertNull(st);
//	}
//	
//	@Test
//	void testListOfStudents() {
//		List<Student> students = studentDao.listOfStudents(10);
//		assertEquals(7, students.size());
//		students.forEach(st -> System.out.println(st));
//	}
//
//	@Test
//	void testUpdateStudent() {
//		Student st = new Student("66", "Smile", 3.7f);
//		studentDao.updateStudent(st);
//	}
	
	@Test
	void testDeleteStudentById() {
		String id = "66";
		studentDao.deleteStudentById(id);
	}
	
}
