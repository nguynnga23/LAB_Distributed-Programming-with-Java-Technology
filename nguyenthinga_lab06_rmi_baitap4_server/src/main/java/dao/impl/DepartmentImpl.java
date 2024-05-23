package dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.DepartmentDao;
import entity.Department;

/**
 * @author Nguyen Thi Nga
 * @date Apr 1, 2024
 */
public class DepartmentImpl extends UnicastRemoteObject implements DepartmentDao {
	private EntityManager em;
	private static final long serialVersionUID = -5922200943574038133L;
	public DepartmentImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA_ORM_Course MSSQL").createEntityManager();
	}

	@Override
	public void close() throws RemoteException {
		em.close();
	}

	@Override
	public boolean addDepartment(Department department) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(department);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateDepartment(Department department) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(department);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDepartment(int id) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Department department = em.find(Department.class, id);
			em.remove(em.contains(department) ? department : em.merge(department));
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Department> findAll() throws RemoteException {
		return em.createNamedQuery("Department.findAll", Department.class).getResultList();
	}

	@Override
	public Department findById(int id) throws RemoteException {
		return em.find(Department.class, id);
	}

	@Override
	public List<Department> findByName(String name) throws RemoteException {
		return em.createNamedQuery("Department.findByName", Department.class).setParameter("name", name + "%")
				.getResultList();
	}

	@Override
	public Map<Department, Long> countCoursesByDepartment() throws RemoteException {

		Map<Department, Long> map = new LinkedHashMap<Department, Long>();

		List<?> results = em.createNamedQuery("Department.countCoursesByDepartment").getResultList();

		results.stream().map(o -> (Object[]) o).forEach(o -> {
			int departmentID = (int) o[0];
			Department department = em.find(Department.class, departmentID);
			long count = (long) o[1];
			map.put(department, count);
		});

		return map;
	}
}