package dao.impl;

import java.util.List;

import dao.IntructorDao;
import entity.Department;
import entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Apr 3, 2024
 */
public class IntructorImpl implements IntructorDao {
	private EntityManager em;

	public IntructorImpl() {
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}

	public void close() {
		em.close();
	}

	@Override
	public boolean addInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(instructor);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateInstructor(Instructor instructor) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(instructor);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteInstructor(int id) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Instructor instructor = em.find(Instructor.class, id);
			em.remove(em.contains(instructor) ? instructor : em.merge(instructor));
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Instructor> findAll() {
		return em.createNamedQuery("Instructor.findAll", Instructor.class).getResultList();
	}

	@Override
	public Instructor findById(int id) {
		return em.find(Instructor.class, id);
	}

	@Override
	public List<Instructor> findByName(String name) {
		return em.createNamedQuery("Instructor.findByName", Instructor.class).setParameter("name", name + "%").getResultList();
	}

}
