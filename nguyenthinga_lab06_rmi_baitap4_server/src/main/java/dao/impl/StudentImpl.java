package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.StudentDao;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public class StudentImpl extends UnicastRemoteObject implements StudentDao {
	private EntityManager em;
	private static final long serialVersionUID = -5922200943574038133L;

	public StudentImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}

	@Override
	public void close() throws RemoteException {
		em.close();
	}

	@Override
	public List<Student> findByEnrollmentInYear(int year) throws RemoteException {
		return em.createNamedQuery("Student.findByEnrollmentInYear", Student.class).setParameter("year", year)
				.getResultList();
	}

	@Override
	public List<Student> findByEnrollmentInCourse(String title) throws RemoteException {
		return em.createNamedQuery("Student.findStudentsEnrolledInCourse", Student.class)
				.setParameter("title", "%" + title + "%").getResultList();
	}
}
