package dao;

import java.util.List;

import dao.impl.CourseImpl;
import entity.Course;
import entity.Department;
import entity.Instructor;
import entity.OnsiteCourse;
import jakarta.persistence.EntityManager;

/**
 * @author Nguyen Thi Nga
 * @date Apr 6, 2024
 */
public interface CourseDao {
	
	public void close();
	
	public List<Course> findAll();


	public boolean addCourse(Course course);

	public boolean updateCourse(Course course);

	public boolean deleteCourse(int id);

	public Course findCourseByID(int id);

	public Course findCourseByTitle2(String title);

	public List<Course> findCourseByTitle(String title);

	public List<OnsiteCourse> findAllOnsiteCourses();

	public List<Course> findByDepartment(int departmentID);

	/**
	 * @return
	 */
	List<Course> findCoursesWithMaxCredits();
}
