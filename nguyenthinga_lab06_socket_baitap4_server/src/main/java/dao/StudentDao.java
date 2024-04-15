package dao;

import java.util.List;

import entity.Student;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public interface StudentDao {
	
	public void close();

	/**
	 * @param year
	 * @return
	 */
	public List<Student> findByEnrollmentInYear(int year);

	/**
	 * @param title
	 * @return
	 */
	public List<Student> findByEnrollmentInCourse(String title);
}
