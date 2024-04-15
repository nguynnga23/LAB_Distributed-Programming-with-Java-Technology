package dao;

import java.util.List;

import entity.Course;
import entity.StudentGrade;

/**
 * @author Nguyen Thi Nga
 * @date Apr 6, 2024
 */
public interface StudentGradeDao {
	public void close();
	
	public StudentGrade findById(int id);

	public List<StudentGrade> findAll();

	public List<StudentGrade> findStudentByCourse(Course course);
}
