package dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.BookTranslationDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public class BookTranslationImpl implements BookTranslationDao {

	private static EntityManager em;
	
	public BookTranslationImpl() {
		em = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan4_Server").createEntityManager();
	}

	@Override
	public Map<String, Long> countBooksByAuthor() {
		Map<String, Long> result = new LinkedHashMap<>();
		List<?> list = em.createNativeQuery("SELECT ba.author, COUNT(*) AS CountBooks "
				+ "FROM book_translations bt "
				+ "JOIN books b ON b.ISBN = bt.ISBN "
				+ "JOIN books_authors ba ON ba.ISBN = b.ISBN "
				+ "GROUP BY ba.author "
				+ "ORDER BY ba.author").getResultList();
		list.stream().map(o -> (Object[]) o).forEach(a -> {
			String author = (String) a[0];
			Long n = Long.valueOf((Integer) a[1]);
			result.put(author, n);	
		});
		return result;
	}
	
	public static void main(String[] args) {
		BookTranslationDao bookTranslationDao = new BookTranslationImpl();
		Map<String, Long> result = bookTranslationDao.countBooksByAuthor();
		for (Map.Entry<String, Long> entry : result.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}

}
