package demo;

import java.util.ArrayList;
import java.util.List;

import entity.Restaurant;

/**
 * @author Nguyen Thi Nga
 * @date Feb 16, 2024
 */
public class Main {
	public static void main(String[] args) {
//		Restaurant res =  JsonHandlerTheStreamingAPI.fromFile("data/restaurants.json");
//		System.out.println(res);
		List<Restaurant> resList = new ArrayList<Restaurant>();
		resList = JsonHandlerTheStreamingAPI.getListJapaneseRestaurant("data/restaurants2.json");
//		System.out.println(resList);
//		for(Restaurant r : resList) {
//			System.err.println(r);
//		}
		JsonHandlerTheStreamingAPI.toFile(resList, "data/NguyenThiNga_21130791.json");
		System.out.println("Done");
		
		
		
		
	}
}
