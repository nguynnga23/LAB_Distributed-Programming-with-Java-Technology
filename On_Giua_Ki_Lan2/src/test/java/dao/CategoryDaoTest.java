package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Category;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
class CategoryDaoTest {
	private static final String DB_NAME = "neo4j";
	private CategoryDao categoryDao ;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		categoryDao = new CategoryDao(AppUtil.driverInit(), DB_NAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		categoryDao.close();
	}

//	@Test
//	void testgetCategoryByCategoryID() {
//		System.out.println(categoryDao.getCategoryByCategoryID("1"));
//	}
	@Test
	void testAddCategory() {
		Category category = new Category("0", "Nga", "Nga nga nga", "cnjncjxncjuidabchjbvub");
        categoryDao.addCategory(category);
//        Category category2 = categoryDao.getCategoryByCategoryID("0");
//        System.out.println(category2);
//        assertEquals(category.getCategoryId(), category2.getCategoryId());
	}

}
