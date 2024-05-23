package dao;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public interface ReviewsDao {
//	--c) (1.5 điểm) Cập nhật thêm một lượt đánh giá cho một cuốn sách, cập nhật thành công nếu cuốn sách và người đọc đã tồn tại, rating phải từ 1 đến 5 và bình luận không được để trống hay rỗng.
//	--+ updateReviews(isbn: String, readerID: String, rating: int, comment: String): boolean
	public boolean updateReviews(String isbn, String readerID, int rating, String comment);
	
}
