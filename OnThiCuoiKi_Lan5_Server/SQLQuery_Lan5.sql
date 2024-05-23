--a) (1.5 điểm) Liệt kê danh sách các cuốn sách được viết bởi tác giả nào đó khi biết tên tác giả và có điểm đánh giá từ mấy sao trở lên.
--+ listRatedBooks(author: String, rating: int): List<Book>

SELECT DISTINCT b.ISBN, ba.author, r.rating
FROM books b
JOIN books_authors ba ON ba.ISBN = b.ISBN
JOIN reviews r ON r.ISBN = b.ISBN
WHERE ba.author LIKE '%Robert C. Martin%' AND r.rating >= 1

--b) (1.5 điểm) Thống kê số cuốn sách được dịch sang ngôn ngữ khác của từng tác giả, kết quả sắp xếp theo tên tác giả.
--+ countBooksByAuthor(): Map<String, Long>

SELECT ba.author, COUNT(*) AS CountBooks
FROM book_translations bt
JOIN books b ON b.ISBN = bt.ISBN
JOIN books_authors ba ON ba.ISBN = b.ISBN 
GROUP BY ba.author
ORDER BY ba.author

--c) (1.5 điểm) Cập nhật thêm một lượt đánh giá cho một cuốn sách, cập nhật thành công nếu cuốn sách và người đọc đã tồn tại, rating phải từ 1 đến 5 và bình luận không được để trống hay rỗng.
--+ updateReviews(isbn: String, readerID: String, rating: int, comment: String): boolean
