package dao.impl;

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
public class StudentGradeImpl implements StudentGradeDao {
	private EntityManager em;
	

	public StudentGradeImpl() {
		super();
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}
	
	@Override
	public void close() {
		em.close();
	}

	@Override
	public StudentGrade findById(int id) {
		return em.find(StudentGrade.class, id);
	}

	@Override
	public List<StudentGrade> findAll() {
		return em.createNamedQuery("StudentGrade.findAll", StudentGrade.class).getResultList();
	}
	
	@Override
	public List<StudentGrade> findStudentByCourse(Course course) {
		return em.createNamedQuery("StudentGrade.findStudentByCourse", StudentGrade.class)
				.setParameter("course", course).getResultList();
	}

}
