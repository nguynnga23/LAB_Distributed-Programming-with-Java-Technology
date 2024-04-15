package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Course;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
class CourseDaoTest {
	private static final String DB_NAME = "coursedb";
	private CourseDao courseDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		courseDao = new CourseDao(AppUtil.driverInit(), DB_NAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		courseDao.close();
		courseDao = null;
	}
//
//	@Test
//	void testAddCourse() {
//		Course c = new Course(5, "testAddCourse2", "TAC103");
//		String id = courseDao.addCourse(c);
//		String expected = "TAC103";
//		String actual = id;
//		assertEquals(expected, actual);
//	}
	@Test
	void testFindCourseID() {
		String id = "TAC101";
		Course c = courseDao.findCourseByID(id);
		assertNotNull(c);
		assertEquals(5, c.getHours());
		assertEquals("testAddCourse", c.getName());
	}
//
//	@Test
//	void testListOfCourses() {
//		List<Course> courses = courseDao.listOfCourses(5);
//		assertEquals(5, courses.size());
//		courses.forEach(c -> System.out.println(c));
//	}
//
//	@Test
//	void testUpdateCourse() {
//		Course c = new Course(5, "testAddCourse2", "TAC102");
//		courseDao.updateCourse(c);
//	}
//
//	@Test
//	void testDeleteCourse() {
//		String id = "TAC102";
//		courseDao.deleteCourseById(id);
//	}

}
