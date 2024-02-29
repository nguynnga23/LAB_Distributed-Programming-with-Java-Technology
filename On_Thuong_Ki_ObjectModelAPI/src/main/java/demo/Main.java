package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import entity.Restaurant;
import jakarta.json.JsonReader;

/**
 * @author Nguyen Thi Nga
 * @date Feb 16, 2024
 */
public class Main {
	public static void main(String[] args) {
		List<Restaurant> rList = new ArrayList<Restaurant>();

		// Đọc file
		rList = JsonHandlerObjectModelAPI.fromFile("data/restaurants2.json");
		for(Restaurant res : rList) {
			System.out.println(res);
		}
		JsonHandlerObjectModelAPI.toFile(rList, "data/NguyenThiNga_21130791.json");
		System.err.println("Done!!");

	}
}
