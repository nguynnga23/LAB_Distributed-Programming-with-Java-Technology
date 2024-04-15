package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Mar 27, 2024
 */
public class MainSQLServer {
	public static void main(String[] args) {
		// Tạo một phiên Hibernate
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_ORM_BikeStores MSSQL");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			System.out.println("Done!!");
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
