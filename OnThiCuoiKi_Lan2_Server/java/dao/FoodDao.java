package dao;

import java.util.Map;

import entity.Food;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public interface FoodDao {
	public boolean addFood(Food food);
	public Map<Food, Double> listFoodAndCost();
}
