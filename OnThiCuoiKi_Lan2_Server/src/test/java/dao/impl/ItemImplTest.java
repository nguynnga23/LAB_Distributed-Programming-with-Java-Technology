package dao.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ItemDao;
import entity.Item;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
class ItemImplTest {
	private ItemDao itemDao;

	@BeforeEach
	void setUp() throws Exception {
		itemDao = new ItemImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		itemDao = null;
	}

	@Test
	void testListItems() {
		List<Item> items = itemDao.listItems("Anna Food Distributors");
		for (Item item : items) {
			System.out.println(item.toString());
		}
		assertNotNull(items);
		assertEquals(1, items.size());
	}

	@Test
	void testListItems1() {
		List<Item> items = itemDao.listItems("0");
		for (Item item : items) {
			System.out.println(item.toString());
		}
		assertNull(items);
	}

}
