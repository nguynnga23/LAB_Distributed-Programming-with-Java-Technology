package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CourseDao;
import dao.DepartmentDao;
import entity.Course;
import entity.Department;
import entity.OnsiteCourse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Apr 6, 2024
 */
public class CourseImpl extends UnicastRemoteObject implements CourseDao {
	private EntityManager em;
	private static final long serialVersionUID = -5922200943574038133L;

	public CourseImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}

	@Override
	public void close() throws RemoteException {
		em.close();
	}

	@Override
	public boolean addCourse(Course course) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(course);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCourse(Course course) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(course);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCourse(int id) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Course course = em.find(Course.class, id);
			em.remove(course);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Course findCourseByID(int id) throws RemoteException {
		return em.find(Course.class, id);
	}

	@Override
	public Course findCourseByTitle2(String title) throws RemoteException {
		return em.createQuery("select c from Course c where c.title = :title", Course.class)
				.setParameter("title", title).getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public List<Course> findCourseByTitle(String title) throws RemoteException {
		return em.createNamedQuery("Course.findByTitle", Course.class).setParameter("title", "%" + title + "%")
				.getResultList();
	}

	@Override
	public List<Course> findAll() throws RemoteException {
		return em.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	public List<OnsiteCourse> findAllOnsiteCourses() throws RemoteException {
		return em.createNamedQuery("Course.findOnsiteCourses", OnsiteCourse.class).getResultList();
	}

	@Override
	public List<Course> findByDepartment(int departmentID) throws RemoteException {
		return em.createNamedQuery("Course.findByDepartment", Course.class).setParameter("departmentID", departmentID)
				.getResultList();
	}

	@Override
	public List<Course> findCoursesWithMaxCredits() throws RemoteException {
		return em.createNamedQuery("Course.findCoursesWithMaxCredits", Course.class).getResultList();
	}

}
