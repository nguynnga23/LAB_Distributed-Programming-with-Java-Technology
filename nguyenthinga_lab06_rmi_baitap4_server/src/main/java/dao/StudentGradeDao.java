package dao;

import java.util.List;

import entity.Course;
import entity.StudentGrade;

/**
 * @author Nguyen Thi Nga
 * @date Apr 6, 2024
 */
public interface StudentGradeDao extends java.rmi.Remote {
	public void close() throws java.rmi.RemoteException;

	public StudentGrade findById(int id) throws java.rmi.RemoteException;

	public List<StudentGrade> findAll() throws java.rmi.RemoteException;

	public List<StudentGrade> findStudentByCourse(Course course) throws java.rmi.RemoteException;
}
