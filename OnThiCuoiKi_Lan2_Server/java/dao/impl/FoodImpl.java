package dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import dao.FoodDao;
import entity.Food;
import entity.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public class FoodImpl implements FoodDao {
	private static EntityManager em;

	public FoodImpl() {
		em = Persistence.createEntityManagerFactory("OnThiCuoiKi_Lan2_Server").createEntityManager();
	}

	@Override
	public boolean addFood(Food food) {
		EntityTransaction tx = em.getTransaction();
		try {
//			Thêm một món ăn mới. Trong đó, mã số của món phải bắt đầu là F và theo sau ít nhất 3 ký số.
			if (!food.getId().matches("^F\\d{3,}$")) {
				System.out.println("Ma so cua mon phai bat dau la F va theo sau it nhat 3 ky so !!!");
				return false;
			} else {
				tx.begin();
				em.persist(food);
				tx.commit();
				return true;
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<Food, Double> listFoodAndCost() {
		Map<Food, Double> result = new LinkedHashMap<>();
		List<?> list = em.createNativeQuery(
				"SELECT f.id, SUM((ing.quantity + ing.price) + (f.preparation_time + f.serving_time)) * 0.2 AS cost "
						+ "FROM foods f " + "JOIN items_ingredients i_i ON i_i.item_id = f.id "
						+ "JOIN ingredients ing ON ing.ingredient_id = i_i.ingredient_id " + "GROUP BY f.id "
						+ "ORDER BY cost DESC")
				.getResultList();

		List<Object[]> objs = new ArrayList<>();

		for (Object element : list) {
			objs.add((Object[]) element);
		}

		for (Object[] element : objs) {
			String id = (String) element[0];
			Double cost = (Double) element[1];
			result.put(em.find(Food.class, id), cost);
		}
		return result;
	}

	public static void main(String[] args) {
		FoodDao foodDao = new FoodImpl();
		Set<Entry<Food, Double>> n = foodDao.listFoodAndCost().entrySet();
		for (Entry<Food, Double> entry : n) {
			System.out.println(entry.getKey().getId() + "=" + entry.getValue());
		}

//		Food f = new Food(null, null, 0, null, false, null, 0, 0);
		Food f = new Food("F100", "Pho", 25.0, "Pho bo", false, Type.MAIN_COURSE, 10, 5);
		System.out.println(foodDao.addFood(f));
		System.out.println(em.find(Food.class, "F100"));
	}

}
