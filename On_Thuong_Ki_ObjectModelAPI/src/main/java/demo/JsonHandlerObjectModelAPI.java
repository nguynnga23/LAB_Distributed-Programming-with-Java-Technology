package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Address;
import entity.Date;
import entity.Grade;
import entity.Restaurant;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;

/**
 * @author Nguyen Thi Nga
 * @date Feb 16, 2024
 */
public class JsonHandlerObjectModelAPI {

	// Json to Object
	public static List<Restaurant> fromFile(String fileName) {
		List<Restaurant> resList = new ArrayList<Restaurant>();

		Restaurant restaurant = null;
		Address address = null;
		Date date = null;

		try {
			JsonReader reader = Json.createReader(new FileReader(fileName));
			JsonArray jsonArray = reader.readArray();
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonObject restaurantObject = jsonArray.getJsonObject(i);
				String restaurant_id = restaurantObject.getString("restaurant_id");
				Boolean is_closed = restaurantObject.getBoolean("is_closed");
				String name = restaurantObject.getString("name");
				// Object Address
				JsonObject addressObject = restaurantObject.getJsonObject("address");
				String building = addressObject.getString("building");

				JsonArray coordArray = addressObject.getJsonArray("coord");
				Double[] coord = new Double[coordArray.size()];

				for (int k = 0; k < coordArray.size(); k++) {
					JsonNumber jsonNumber = coordArray.getJsonNumber(k);
					System.err.println(jsonNumber);
					if (jsonNumber != null) {
						coord[k] = jsonNumber.doubleValue();
					} else {
						coord[k] = 0.0;
					}
				}

				String street = addressObject.getString("street");
				String zipcode = addressObject.getString("zipcode");
				address = new Address(building, coord, street, zipcode);

				// --------------------------------------------------------
				String borough = restaurantObject.getString("borough");
				String cuisine = restaurantObject.getString("cuisine");

				// Array of Object Grade
				JsonArray gradeArray = restaurantObject.getJsonArray("grades");
				List<Grade> grades = new ArrayList<Grade>();
				for (int j = 0; j < gradeArray.size(); j++) {
					JsonObject gradeObject = gradeArray.getJsonObject(j);
					JsonObject dateObject = gradeObject.getJsonObject("date");
					int year = dateObject.getInt("year");
					int month = dateObject.getInt("month");
					int day = dateObject.getInt("day");
					date = new Date(year, month, day);
					String grade = gradeObject.getString("grade");
					int score = gradeObject.getInt("score");
					grades.add(new Grade(date, grade, score));
				}

				restaurant = new Restaurant(restaurant_id, is_closed, name, address, borough, cuisine, grades);
				
				if (restaurant.getCuisine().equals("Japanese")) {
					resList.add(restaurant);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return resList;

	}

	// Object to Json
	public static void toFile(List<Restaurant> resList, String fileName) {
		try {
			JsonWriter writer = Json.createWriter(new FileWriter(fileName));
			JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
			for (Restaurant res : resList) {
				// Tạo đối tượng restaurant
				JsonObjectBuilder restaurantBuilder = Json.createObjectBuilder();
				restaurantBuilder.add("restaurant_id", res.getRestaurant_id());
				restaurantBuilder.add("is_closed", res.getIs_closed());
				restaurantBuilder.add("name", res.getName());

				// Tạo đối tượng address
				JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
				addressBuilder.add("building", res.getAddress().getBuilding());
				// Tạo mảng coord
				JsonArrayBuilder coordArrayBuilder = Json.createArrayBuilder();
				for (Double coord : res.getAddress().getCoord()) {
					coordArrayBuilder.add(coord);
				}
				// Thêm mảng coord vào address
				addressBuilder.add("coord", coordArrayBuilder);
				addressBuilder.add("street", res.getAddress().getStreet());
				addressBuilder.add("zipcode", res.getAddress().getZipcode());
				restaurantBuilder.add("address", addressBuilder);
				restaurantBuilder.add("borough", res.getBorough());
				restaurantBuilder.add("cuisine", res.getCuisine());

				// Tạo mảng Json cho danh sach grades
				JsonArrayBuilder gradeArrayBuilder = Json.createArrayBuilder();
				for (Grade g : res.getGrades()) {
					JsonObjectBuilder gradeBuilder = Json.createObjectBuilder();
					JsonObjectBuilder dateBuilder = Json.createObjectBuilder();
					dateBuilder.add("year", g.getDate().getYear());
					dateBuilder.add("month", g.getDate().getMonth());
					dateBuilder.add("day", g.getDate().getDay());
					gradeBuilder.add("date", dateBuilder);
					gradeBuilder.add("grade", g.getGrade());
					gradeBuilder.add("score", g.getScore());

					gradeArrayBuilder.add(gradeBuilder);
				}
				restaurantBuilder.add("grades", gradeArrayBuilder);

				jsonArrayBuilder.add(restaurantBuilder);

			}
			JsonArray ja = jsonArrayBuilder.build();
			writer.write(ja);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
