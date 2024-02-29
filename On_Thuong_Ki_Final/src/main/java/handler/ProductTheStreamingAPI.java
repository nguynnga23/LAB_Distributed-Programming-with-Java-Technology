package handler;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import entity.Product;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

/**
 * @author Nguyen Thi Nga
 * @date Feb 25, 2024
 */
public class ProductTheStreamingAPI {
	// Json to object
	public static List<Product> fromFile(String fileName) {
		Product p = null;
		List<Category> cList = null;
		List<Product> pList = null;
		String keyName = "";

		try {
			JsonParser parser = Json.createParser(new FileReader(fileName));
			while (parser.hasNext()) {
				Event e = parser.next();
				switch (e) {
				case START_OBJECT:
					if (keyName.equals("")) {
						p = new Product();
					}
					break;
				case START_ARRAY:
					if (keyName.equals("")) {
						pList = new ArrayList<Product>();
					} else {
						JsonArray ja = parser.getArray();
						cList = new ArrayList<Category>();
						for (JsonValue jv : ja) {
							JsonObject jo = (JsonObject) jv;
							String id = jo.getString("id");
							String name = jo.getString("name");
							cList.add(new Category(id, name));
						}

					}
					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;
				case VALUE_STRING:
					String value = parser.getString();
					setStringValues(p, keyName, value);
					break;
				case VALUE_NUMBER:
					JsonValue jv = parser.getValue();
					if (jv instanceof JsonNumber) {
						JsonNumber jn = (JsonNumber) jv;
						if (keyName.equals("price")) {
							p.setPrice(jn.bigDecimalValue().floatValue());
						} else if (keyName.equals("sku")) {
							p.setSku(jn.intValue());
						} else {
							p.setShipping(jn.bigDecimalValue().floatValue());
						}

					}

					break;
				case END_OBJECT:
					p.setCategory(cList);
					pList.add(p);
					break;

				case END_ARRAY:
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("cccc");
		}
		return pList;

	}

	public static void setStringValues(Product p, String keyName, String value) {
		switch (keyName) {
		case "name":
			p.setName(value);
			;
			break;
		case "type":
			p.setType(value);
			break;
		case "description":
			p.setDescription(value);
			break;
		case "manufacturer":
			p.setManufacturer(value);
			break;
		case "model":
			p.setModel(value);
			break;
		case "url":
			p.setModel(value);
			break;
		case "image":
			p.setImage(value);
			break;

		default:
			break;
		}
	}

	public static void toFile(List<Product> pList, String fileName) {
		try {
			JsonGenerator gen = Json.createGenerator(new FileWriter(fileName));
			gen.writeStartArray();
			for(Product p : pList) {
				gen.writeStartObject();
				gen.write("sku", p.getSku());
				gen.write("name", p.getName());
				gen.write("type", p.getType());
				gen.write("price", p.getPrice());
				gen.write("upc", p.getUpc());
				
				gen.writeStartArray("category");
				for(Category c : p.getCategory()) {
					gen.writeStartObject();
					gen.write("id", c.getId());
					gen.write("name", c.getName());
					gen.writeEnd();
				}
				gen.writeEnd();
				
				gen.write("shipping", p.getShipping());
				gen.write("description", p.getDescription());
				gen.write("manufacturer", p.getManufacturer());
				gen.write("model", p.getModel());
				gen.write("url", p.getUrl());
				gen.write("image", p.getImage());
				
				gen.writeEnd();
				}
			gen.writeEnd();
			gen.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
