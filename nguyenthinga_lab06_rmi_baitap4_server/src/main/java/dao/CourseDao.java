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
public interface CourseDao extends java.rmi.Remote {

	public void close() throws java.rmi.RemoteException;

	public List<Course> findAll() throws java.rmi.RemoteException;

	public boolean addCourse(Course course) throws java.rmi.RemoteException;

	public boolean updateCourse(Course course) throws java.rmi.RemoteException;

	public boolean deleteCourse(int id) throws java.rmi.RemoteException;

	public Course findCourseByID(int id) throws java.rmi.RemoteException;

	public Course findCourseByTitle2(String title) throws java.rmi.RemoteException;

	public List<Course> findCourseByTitle(String title) throws java.rmi.RemoteException;

	public List<OnsiteCourse> findAllOnsiteCourses() throws java.rmi.RemoteException;

	public List<Course> findByDepartment(int departmentID) throws java.rmi.RemoteException;

	public List<Course> findCoursesWithMaxCredits() throws java.rmi.RemoteException;
}
