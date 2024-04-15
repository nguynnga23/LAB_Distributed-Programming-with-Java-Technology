package dao;

import java.util.List;

import entity.Student;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public interface StudentDao extends java.rmi.Remote {
	
	public void close() throws java.rmi.RemoteException;

	public List<Student> findByEnrollmentInYear(int year) throws java.rmi.RemoteException;

	public List<Student> findByEnrollmentInCourse(String title) throws java.rmi.RemoteException;
}
