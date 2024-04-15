package dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Course;
import entity.Department;
import entity.OnlineCourse;
import entity.OnsiteCourse;

/**
 * @author Nguyen Thi Nga
 * @date Apr 6, 2024
 */
class CourseImplTest {
	private CourseImpl courseImpl;
	private DepartmentImpl departmentImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		courseImpl = new CourseImpl();
		departmentImpl = new DepartmentImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		courseImpl.close();
		departmentImpl.close();
	}

	@Test
	void testFindAll() {
		System.err.println("testFindAll");
		List<Course> courses = courseImpl.findAll();
		for (Course course : courses) {
			System.out.println(course);
		}
		assertEquals(10, courseImpl.findAll().size());
	}

	@Test
	void testFindById() {
		System.err.println("testFindById");
		Course course = courseImpl.findCourseByID(2021);
		System.out.println(course);
		assertNotNull(course);
		assertNull(courseImpl.findCourseByID(100));
	}
	
	@Test
	void testFindByTitle() {
		System.err.println("testFindByTitle");
		List<Course> courses = courseImpl.findCourseByTitle("c");
		for (Course course : courses) {
			System.out.println(course);
		}
	}
	
	@Test
	void testFindByDepartment() {
		System.err.println("testFindByDepartment");
		List<Course> courses = courseImpl.findByDepartment(1);
		for (Course course : courses) {
			System.out.println(course);
		}
	}
	
	@Test
	void testFindCoursesWithMaxCredits() {
		System.err.println("testFindCoursesWithMaxCredits");
		List<Course> courses = courseImpl.findCoursesWithMaxCredits();
		for (Course course : courses) {
			System.out.println(course);
		}
	}
}
