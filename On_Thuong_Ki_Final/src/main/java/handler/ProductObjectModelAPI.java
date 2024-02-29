package handler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import entity.Product;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;

/**
 * @author Nguyen Thi Nga
 * @date Feb 25, 2024
 */
public class ProductObjectModelAPI {
	// Json to Object
	public static Product fromFile(String fileName) {
		Product p = null;
		Category c = null;
		List<Category> cList = null;
		try {
			JsonReader reader = Json.createReader(new FileReader(fileName));
			JsonObject jo = reader.readObject();
			int sku = jo.getInt("sku");
			String name = jo.getString("name");
			String type = jo.getString("type");
			float price = jo.getJsonNumber("price").bigDecimalValue().floatValue();
			String upc = jo.getString("upc");
			float shipping = jo.getJsonNumber("shipping").bigDecimalValue().floatValue();
			String description = jo.getString("description");
			String manufacturer = jo.getString("manufacturer");
			String model = jo.getString("model");
			String url = jo.getString("url");
			String image = jo.getString("image");

			// Object category
			JsonArray ja = jo.getJsonArray("category");
			cList = new ArrayList<Category>();

			for (int i = 0; i < ja.size(); i++) {
				JsonObject joCategory = ja.getJsonObject(i);
				String id = joCategory.getString("id");
				String cName = jo.getString("name");
				c = new Category(id, cName);
				cList.add(c);
			}
			p = new Product(sku, name, type, price, upc, cList, shipping, description, manufacturer, model, url, image);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return p;
	}

	// Json to Array Object
	public static List<Product> getProducts(String fileName) {
		List<Product> pList = new ArrayList<Product>();
		Product p = null;
		Category c = null;
		List<Category> cList = null;
		try {
			JsonReader reader = Json.createReader(new FileReader(fileName));
			JsonArray jaP = reader.readArray();
			for (int i = 0; i < jaP.size(); i++) {
				JsonObject jo = jaP.getJsonObject(i);
				int sku = jo.getInt("sku");
				String name = jo.getString("name");
				String type = jo.getString("type");
				float price = jo.getJsonNumber("price").bigDecimalValue().floatValue();
				String upc = jo.getString("upc");
				float shipping = jo.getJsonNumber("shipping").bigDecimalValue().floatValue();
				String description = jo.getString("description");
				String manufacturer = jo.getString("manufacturer");
				String model = jo.getString("model");
				String url = jo.getString("url");
				String image = jo.getString("image");

				// Object category
				JsonArray ja = jo.getJsonArray("category");
				cList = new ArrayList<Category>();

				for (int j = 0; j < ja.size(); j++) {
					JsonObject joCategory = ja.getJsonObject(i);
					String id = joCategory.getString("id");
					String cName = jo.getString("name");
					c = new Category(id, cName);
					cList.add(c);
				}
				p = new Product(sku, name, type, price, upc, cList, shipping, description, manufacturer, model, url,
						image);

				pList.add(p);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return pList;

	}

	// Object to Json
	public static void toFile(List<Product> pList, String fileName) {
		try {
			JsonWriter writer = Json.createWriter(new FileWriter(fileName));
			JsonArrayBuilder jaBuilder = Json.createArrayBuilder();
			for (Product p : pList) {
				JsonObjectBuilder jobProduct = Json.createObjectBuilder();
				jobProduct.add("sku", p.getSku());
				jobProduct.add("name", p.getName());
				jobProduct.add("type", p.getType());
				jobProduct.add("price", p.getPrice());
				jobProduct.add("upc", p.getUpc());
				JsonArrayBuilder jabCategory = Json.createArrayBuilder();
				for (Category c : p.getCategory()) {
					JsonObjectBuilder jobCategory = Json.createObjectBuilder();
					jobCategory.add("id", c.getId());
					jobCategory.add("name", c.getName());
					jabCategory.add(jobCategory);
				}
				jobProduct.add("grades", jabCategory);
				jobProduct.add("shipping", p.getShipping());
				jobProduct.add("description", p.getDescription());
				jobProduct.add("manufacturer", p.getManufacturer());
				jobProduct.add("model", p.getModel());
				jobProduct.add("url", p.getUrl());
				jobProduct.add("image", p.getImage());
				jaBuilder.add(jobProduct);
			}
			JsonArray ja = jaBuilder.build();
			writer.write(ja);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
