package demo;

import java.util.List;

import entity.Product;
import handler.ProductObjectModelAPI;

/**
 * @author Nguyen Thi Nga
 * @date Feb 25, 2024
 */
public class ObjectModelAPI_Demo {
	public static void main(String[] args) {
		List<Product> pList = ProductObjectModelAPI.getProducts("data/products.json");
		for(Product p : pList) {
			System.out.println(p);
		}
		ProductObjectModelAPI.toFile(pList, "data/nguyenthinga_21130791.json");
		System.out.println("Done!");
	}
}
