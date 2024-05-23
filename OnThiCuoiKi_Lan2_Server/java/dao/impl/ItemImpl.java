package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ItemDao;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public class ItemImpl implements ItemDao {
	private EntityManager em;

	public ItemImpl() {
		em = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan2_Server").createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> listItems(String supplierName) {
		List<Item> items = new ArrayList<>();
		List<?>list = em.createNativeQuery("SELECT i.id FROM items i JOIN beverages b ON b.id = i.id "
				+ "WHERE i.on_special = 1 AND b.supplier_name LIKE ?").setParameter(1, "%" + supplierName + "%").getResultList();
		for (Object object : list) {
			String id = (String) object;
			items.add(em.find(Item.class, id));
		}
		return items;
	}

	public static void main(String[] args) {
		ItemImpl itemDao = new ItemImpl();
		List<Item> items = itemDao.listItems("Anna Food Distributors");
		for (Item item : items) {
			System.out.println(item.toString());
		}
	}

}
