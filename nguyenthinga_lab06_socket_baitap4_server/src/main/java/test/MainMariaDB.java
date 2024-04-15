package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Mar 26, 2024
 */
public class MainMariaDB {
	public static void main(String[] args) {
		// Tạo một phiên Hibernate
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA ORM MariaDB");
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
