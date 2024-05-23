package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public class BookImpl implements BookDao {
	private static EntityManager em;

	public BookImpl() {
		em = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan4_Server").createEntityManager();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listRatedBooks(String author, int rating) {
		return em.createNamedQuery("Book.listRatedBooks", Book.class).setParameter("author", author).setParameter("rating", rating)
				.getResultList();
		
	}

	public static void main(String[] args) {
		BookDao bookDao = new BookImpl();
		List<Book> books = bookDao.listRatedBooks("Martin Fowler", 2);
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
