package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.PatientDao;
import entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
public class PatientImpl extends UnicastRemoteObject implements PatientDao {

	private static final long serialVersionUID = 4394856318971102847L;
	private EntityManager em;

	public PatientImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA_ORM_MSSQL").createEntityManager();
	}

	@Override
	public boolean addPatient(Patient patient) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(patient);
			tx.commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

}
