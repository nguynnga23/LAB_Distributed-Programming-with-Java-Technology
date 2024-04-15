package dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.CourseDao;
import dao.StudentGradeDao;
import entity.Course;
import entity.StudentGrade;

/**
 * @author Nguyen Thi Nga
 * @date Apr 6, 2024
 */
class StudentGradeImplTest {
	private StudentGradeDao studentGradeDao;
	private CourseDao courseDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		studentGradeDao = new StudentGradeImpl();
		courseDao = new CourseImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		studentGradeDao.close();
		courseDao.close();
	}

	@Test
	void testFindAll() throws RemoteException {
		System.err.println("testFindAll");
		List<StudentGrade> studentGrades = studentGradeDao.findAll();
		for (StudentGrade studentGrade : studentGrades) {
			System.out.println(studentGrade);
		}
//		assertNotNull(studentGradeImpl.findAll());
//		assertEquals(10, studentGradeImpl.findAll().size());

	}

	@Test
	void testFindStudentByCourse() throws RemoteException {
		System.err.println("testFindStudentByCourse");
		Course course = courseDao.findCourseByID(2021);
		List<StudentGrade> studentGrades = studentGradeDao.findStudentByCourse(course);
		for (StudentGrade studentGrade : studentGrades) {
			System.out.println(studentGrade);
		}
	}

}
