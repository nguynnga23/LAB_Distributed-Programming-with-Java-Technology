package dao.impl;

import java.util.List;

import dao.StudentDao;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public class StudentImpl implements StudentDao {
	private EntityManager em;

	public StudentImpl() {
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}

	@Override
	public void close() {
		em.close();
	}

	@Override
	public List<Student> findByEnrollmentInYear(int year) {
		return em.createNamedQuery("Student.findByEnrollmentInYear", Student.class).setParameter("year", year)
				.getResultList();
	}

	@Override
	public List<Student> findByEnrollmentInCourse(String title) {
		return em.createNamedQuery("Student.findStudentsEnrolledInCourse", Student.class)
				.setParameter("title", "%" + title + "%").getResultList();
	}
}
