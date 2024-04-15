package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.StudentGradeDao;
import entity.Course;
import entity.StudentGrade;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Apr 6, 2024
 */
public class StudentGradeImpl extends UnicastRemoteObject implements StudentGradeDao {
	private EntityManager em;
	private static final long serialVersionUID = -5922200943574038133L;

	public StudentGradeImpl() throws RemoteException {
		super();
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}

	@Override
	public void close() throws RemoteException {
		em.close();
	}

	@Override
	public StudentGrade findById(int id) throws RemoteException {
		return em.find(StudentGrade.class, id);
	}

	@Override
	public List<StudentGrade> findAll() throws RemoteException {
		return em.createNamedQuery("StudentGrade.findAll", StudentGrade.class).getResultList();
	}

	@Override
	public List<StudentGrade> findStudentByCourse(Course course) throws RemoteException {
		return em.createNamedQuery("StudentGrade.findStudentByCourse", StudentGrade.class)
				.setParameter("course", course).getResultList();
	}

}
