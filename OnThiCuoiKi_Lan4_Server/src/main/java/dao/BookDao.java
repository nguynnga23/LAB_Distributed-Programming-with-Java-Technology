package dao;

import java.util.List;

import entity.Book;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public interface BookDao {
//	--a) (1.5 điểm) Liệt kê danh sách các cuốn sách được viết bởi tác giả nào đó khi biết tên tác giả và có điểm đánh giá từ mấy sao trở lên.
//	--+ listRatedBooks(author: String, rating: int): List<Book>
//	--b.ISBN, ba.author, r.rating
	public List<Book> listRatedBooks(String author, int rating);
	
}
