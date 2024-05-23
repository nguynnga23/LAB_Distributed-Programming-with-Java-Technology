package dao;

import java.util.List;

import entity.Item;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public interface ItemDao {
	public List<Item> listItems(String supplierName);
}
