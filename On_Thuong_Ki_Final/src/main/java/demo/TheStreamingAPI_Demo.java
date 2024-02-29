package demo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import entity.Product;
import handler.ProductTheStreamingAPI;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

/**
 * @author Nguyen Thi Nga
 * @date Feb 25, 2024
 */
public class TheStreamingAPI_Demo {
	public static void main(String[] args) {
		List<Product> pList = ProductTheStreamingAPI.fromFile("data/products.json");
		for (Product p : pList) {
			System.out.println(p);
		}
		ProductTheStreamingAPI.toFile(pList, "data/2nguyenthinga_21130791.json");
		System.out.println("Done!");
	}
}
