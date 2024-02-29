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
import jakarta.json.JsonObject;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

/**
 * @author Nguyen Thi Nga
 * @date Feb 16, 2024
 */
public class JsonHandlerTheStreamingAPI {

	// Json to Object
	public static Restaurant fromFile(String fileName) {
//		List<Restaurant> resList = null;
		Restaurant res = null;
		Address add = null;
		Date date = null;
		List<Grade> grades = null;
		String keyName = "";
		try {
			JsonParser parser = Json.createParser(new FileReader(fileName));
			while (parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT:
					if (keyName.equals("address"))
						add = new Address();
					else if (keyName.equals("date"))
						date = new Date();
					else
						res = new Restaurant();

					break;
				case START_ARRAY:
					JsonArray ja = parser.getArray();
					System.err.println(ja);
					if (keyName.equals("grades")) {
						grades = new ArrayList<Grade>();
						for (JsonValue jv : ja) {
							JsonObject joGrade = (JsonObject) jv;
							JsonObject joDate = joGrade.getJsonObject("date");
							date = new Date(joDate.getInt("year"), joDate.getInt("month"), joDate.getInt("day"));
							grades.add(new Grade(date, joGrade.getString("grade"), joGrade.getInt("score")));
						}
					} else if (keyName.equals("coord")) {
						Double[] coord = new Double[ja.size()];
						for (int i = 0; i < ja.size(); i++) {
							coord[i] = ja.getJsonNumber(i).doubleValue();
						}
						add.setCoord(coord);
					}

					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;
				case VALUE_STRING:
					String value = parser.getString();
					setStringValues(res, add, date, keyName, value);
					break;
				case VALUE_NUMBER:
					break;
				case VALUE_TRUE:
					res.setIs_closed(true);
					break;
				case VALUE_FALSE:
					res.setIs_closed(false);
					break;
				case VALUE_NULL:
					break;
				case END_OBJECT:
					res.setAddress(add);
					res.setGrades(grades);
					System.err.println("Done");
					break;
				case END_ARRAY:
//					resList.add(res);
					break;

				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;

	}

	public static List<Restaurant> getListRestaurant(String fileName) {
		List<Restaurant> resList = null;
		Restaurant res = null;
		Address add = null;
		Date date = null;
		List<Grade> grades = null;
		String keyName = "";
		try {
			JsonParser parser = Json.createParser(new FileReader(fileName));
			while (parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT:
					if (keyName.equals("address"))
						add = new Address();
					else if (keyName.equals("date"))
						date = new Date();
					else
						res = new Restaurant();

					break;
				case START_ARRAY:
					if (keyName.equals("")) {
						resList = new ArrayList<Restaurant>();
						break;
					} else {
						JsonArray ja = parser.getArray();
						if (keyName.equals("grades")) {
							grades = new ArrayList<Grade>();
							for (JsonValue jv : ja) {
								JsonObject joGrade = (JsonObject) jv;
								JsonObject joDate = joGrade.getJsonObject("date");
								date = new Date(joDate.getInt("year"), joDate.getInt("month"), joDate.getInt("day"));
								grades.add(new Grade(date, joGrade.getString("grade"), joGrade.getInt("score")));
							}
						} else if (keyName.equals("coord")) {
							Double[] coord = new Double[ja.size()];
							for (int i = 0; i < ja.size(); i++) {
								coord[i] = ja.getJsonNumber(i).doubleValue();
							}
							add.setCoord(coord);
						}

					}

					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;
				case VALUE_STRING:
					String value = parser.getString();
					setStringValues(res, add, date, keyName, value);
					break;
				case VALUE_NUMBER:
					break;
				case VALUE_TRUE:
					res.setIs_closed(true);
					break;
				case VALUE_FALSE:
					res.setIs_closed(false);
					break;
				case VALUE_NULL:
					break;
				case END_OBJECT:
					if (keyName.equals("grades")) {
						res.setAddress(add);
						res.setGrades(grades);
						resList.add(res);
					}
					break;
				case END_ARRAY:
					break;

				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resList;

	}

	public static List<Restaurant> getListJapaneseRestaurant(String fileName) {
		List<Restaurant> resList = null;
		Restaurant res = null;
		Address add = null;
		Date date = null;
		List<Grade> grades = null;
		String keyName = "";
		try {
			JsonParser parser = Json.createParser(new FileReader(fileName));
			while (parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT:
					if (keyName.equals("address"))
						add = new Address();
					else if (keyName.equals("date"))
						date = new Date();
					else
						res = new Restaurant();

					break;
				case START_ARRAY:
					if (keyName.equals("")) {
						resList = new ArrayList<Restaurant>();
						break;
					} else {
						JsonArray ja = parser.getArray();
						if (keyName.equals("grades")) {
							grades = new ArrayList<Grade>();
							for (JsonValue jv : ja) {
								JsonObject joGrade = (JsonObject) jv;
								JsonObject joDate = joGrade.getJsonObject("date");
								date = new Date(joDate.getInt("year"), joDate.getInt("month"), joDate.getInt("day"));
								grades.add(new Grade(date, joGrade.getString("grade"), joGrade.getInt("score")));
							}
						} else if (keyName.equals("coord")) {
							Double[] coord = new Double[ja.size()];
							for (int i = 0; i < ja.size(); i++) {
								coord[i] = ja.getJsonNumber(i).doubleValue();
							}
							add.setCoord(coord);
						}

					}

					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;
				case VALUE_STRING:
					String value = parser.getString();
					setStringValues(res, add, date, keyName, value);
					break;
				case VALUE_NUMBER:
					break;
				case VALUE_TRUE:
					res.setIs_closed(true);
					break;
				case VALUE_FALSE:
					res.setIs_closed(false);
					break;
				case VALUE_NULL:
					break;
				case END_OBJECT:
					if (keyName.equals("grades")) {
						res.setAddress(add);
						res.setGrades(grades);
						if (res.getCuisine().equals("Japanese"))
							resList.add(res);
					}
					break;
				case END_ARRAY:
					break;

				default:
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resList;

	}

	/**
	 * 
	 */
	private static void setStringValues(Restaurant r, Address add, Date d, String keyName, String value) {
		switch (keyName) {
		case "restaurant_id":
			r.setRestaurant_id(value);
			break;
		case "name":
			r.setName(value);
			break;
		case "building":
			add.setBuilding(value);
			break;
		case "street":
			add.setStreet(value);
			break;
		case "zipcode":
			add.setZipcode(value);
			break;
		case "borough":
			r.setBorough(value);
			break;
		case "cuisine":
			r.setCuisine(value);
			break;
		default:
			break;
		}
	}

	// Object to Json
	public static void toFile(List<Restaurant> resList, String fileName) {
		try (JsonGenerator jgen = Json.createGenerator(new FileWriter(fileName))) {
			jgen.writeStartArray();
			for(Restaurant res : resList) {
				jgen.writeStartObject();
				jgen.write("restaurant_id", res.getRestaurant_id());
				jgen.write("is_closed", res.getIs_closed());
				jgen.write("name", res.getName());
				jgen.write("borough", res.getBorough());
				jgen.write("cuisine", res.getCuisine());

				// Ghi object address
				jgen.writeStartObject("address");
				Address add = res.getAddress();
				jgen.write("building", add.getBuilding());
				// Ghi mảng coord
				jgen.writeStartArray("coord");
				for (Double coord : add.getCoord()) {
					jgen.write(coord);
				}
				jgen.writeEnd(); // End coord array

				jgen.write("street", add.getStreet());
				jgen.write("zipcode", add.getZipcode());
				jgen.writeEnd(); // End object address

				// Write grades array
				jgen.writeStartArray("grades");
				for (Grade g : res.getGrades()) {
					jgen.writeStartObject();
					jgen.writeStartObject("date");
					jgen.write("year", g.getDate().getYear());
					jgen.write("month", g.getDate().getMonth());
					jgen.write("day", g.getDate().getDay());
					jgen.writeEnd(); // End date object
					jgen.write("grade", g.getGrade());
					jgen.write("score", g.getScore());
					jgen.writeEnd(); // End grade object
				}
				jgen.writeEnd(); // End grades array

				jgen.writeEnd(); // End the main object
				
			}
			jgen.writeEnd();
			jgen.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
