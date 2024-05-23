package dao;

import java.util.Map;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public interface BookTranslationDao {
//	--b) (1.5 điểm) Thống kê số cuốn sách được dịch sang ngôn ngữ khác của từng tác giả, kết quả sắp xếp theo tên tác giả.
//	--+ countBooksByAuthor(): Map<String, Long>
	public Map<String, Long> countBooksByAuthor();
	
}