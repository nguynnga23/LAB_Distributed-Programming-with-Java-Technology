package dao.impl;

import dao.ReviewsDao;
import entity.Book;
import entity.Person;
import entity.Reviews;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public class ReviewsImpl implements ReviewsDao {
	private static EntityManager em;

	public ReviewsImpl() {
		em = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan4_Server").createEntityManager();
	}

//	Cập nhật thêm một lượt đánh giá cho một cuốn sách, cập nhật thành công nếu cuốn sách và người đọc đã tồn tại, rating phải từ 1 đến 5 và bình luận không được để trống hay rỗng.
//	--+ updateReviews(isbn: String, readerID: String, rating: int, comment: String): boolean

	@Override
	public boolean updateReviews(String isbn, String readerID, int rating, String comment) {
		EntityTransaction tx = em.getTransaction();
		Reviews r = new Reviews();
		r.setRating(rating);
		r.setComment(comment);
		r.setBook(em.find(Book.class, isbn));
		r.setPerson(em.find(Person.class, readerID));

		if (rating < 1 || rating > 5 || comment == null || comment.isEmpty() || em.find(Book.class, isbn) == null
				|| em.find(Person.class, readerID) == null) {
			System.out.println("Lỗi nhập dữ liệu!");
			return false;
		}
		else {
			try {
				tx.begin();
				em.persist(r);
				tx.commit();
				return true;
			} catch (Exception e) {
				tx.rollback();
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		ReviewsDao reviewsDao = new ReviewsImpl();
		String isbn = "888-0321115217";
		String readerID = "200";
		int rating = 4;
		String comment = "Good book!";
		System.out.println(reviewsDao.updateReviews(isbn, readerID, rating, comment));
	}

}
