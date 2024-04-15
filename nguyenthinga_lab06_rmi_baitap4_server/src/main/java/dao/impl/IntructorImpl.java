package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class IntructorImpl extends UnicastRemoteObject implements IntructorDao {
	private EntityManager em;
	private static final long serialVersionUID = -5922200943574038133L;
	public IntructorImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}

	@Override
	public void close() throws RemoteException {
		em.close();
	}

	@Override
	public boolean addInstructor(Instructor instructor)  throws RemoteException{
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
	public boolean updateInstructor(Instructor instructor)  throws RemoteException{
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
	public boolean deleteInstructor(int id)  throws RemoteException{
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
	public List<Instructor> findAll()  throws RemoteException{
		return em.createNamedQuery("Instructor.findAll", Instructor.class).getResultList();
	}

	@Override
	public Instructor findById(int id)  throws RemoteException{
		return em.find(Instructor.class, id);
	}

	@Override
	public List<Instructor> findByName(String name)  throws RemoteException{
		return em.createNamedQuery("Instructor.findByName", Instructor.class).setParameter("name", name + "%").getResultList();
	}

}
