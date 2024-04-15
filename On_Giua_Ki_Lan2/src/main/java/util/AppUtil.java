package util;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.neo4j.driver.AuthToken;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.types.Node;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import dao.CategoryDao;
import dao.CustomerDao;
import dao.SupplierDao;
import entity.Address;
import entity.Category;
import entity.Contact;
import entity.Customer;
import entity.Order;
import entity.Product;
import entity.Supplier;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
public class AppUtil {
	private static final String DB_NAME = "neo4j";

	public static Driver driverInit() {
		URI uri = URI.create("neo4j://localhost:7687");
		String username = "neo4j";
		String password = "12345678";
		return GraphDatabase.driver(uri, AuthTokens.basic(username, password));
	}

	private static final Gson GSON = new GsonBuilder().create();

	public static <T> T nodeToPOJO(Node node, Class<T> clazz) {
		Map<String, Object> properties = node.asMap();
		String json = GSON.toJson(properties);
		T obj = GSON.fromJson(json, clazz);
		return obj;
	}

	public static <T> Map<String, Object> getProperties(T t) {
		String json = GSON.toJson(t);
		Map<String, Object> map = GSON.fromJson(json, new TypeToken<Map<String, Object>>() {
		});
		return map;
	}

	public static Customer nodeToCustomer(Node node) {
		Map<String, Object> properties = node.asMap();
		String json = GSON.toJson(properties);
		Address address = GSON.fromJson(json, Address.class);
		Contact contact = GSON.fromJson(json, Contact.class);
		Customer customer = GSON.fromJson(json, Customer.class);
		customer.setAddress(address);
		customer.setContact(contact);
		return customer;

	}

	public static Category nodeToCategory(Node node) {
		Map<String, Object> properties = node.asMap();
		String json = GSON.toJson(properties);
		Category category = GSON.fromJson(json, Category.class);
		return category;
	}

	public static Supplier nodeToSupplier(Node node) {
		Map<String, Object> properties = node.asMap();
		String json = GSON.toJson(properties);
		Address address = GSON.fromJson(json, Address.class);
		Contact contact = GSON.fromJson(json, Contact.class);
		Supplier supplier = GSON.fromJson(json, Supplier.class);
		supplier.setAddress(address);
		supplier.setContact(contact);
		return supplier;
	}

	public static Product nodeToProduct(Node node) {
		Map<String, Object> properties = node.asMap();
		String json = GSON.toJson(properties);
		SupplierDao supplierDao = new SupplierDao(driverInit(), DB_NAME);
		CategoryDao categoryDao = new CategoryDao(driverInit(), DB_NAME);
		Supplier supplier = supplierDao.getSupplierBySupplierID((String) properties.get("supplierID"));
		Category category = categoryDao.getCategoryByCategoryID((String) properties.get("categoryID"));
		Product product = GSON.fromJson(json, Product.class);
		product.setSupplier(supplier);
		product.setCategory(category);
		return product;
	}
//	1996-07-12 00:00:00.000
//	1996-08-01T00:00:00Z
	public static Order nodeToOrder(Node node) {
//		Map<String, Object> properties = node.asMap();
//		String json = GSON.toJson(properties);
//		System.err.println("json: " + json);
		
		String orderID = node.get("orderID").toString();
		String employeeID = node.get("employeeID").toString() ;
		String freight = node.get("freight").toString() ;
		String shipName = node.get("shipName").toString();
//		System.out.println("freight: " + freight);

		String rds = node.get("requiredDate").toString().replace("\"", "").substring(0, 10);
		String ods = node.get("orderDate").toString().replace("\"", "").substring(0, 10);
//		String sd = node.get("shippedDate").toString().replace("\"", "").substring(0, 10);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate requiredDate = LocalDate.parse(rds, formatter);
		LocalDate orderDate = LocalDate.parse(ods, formatter);
//		LocalDate shippedDate = LocalDate.parse(sd, formatter);

		CustomerDao customerDao = new CustomerDao(driverInit(), DB_NAME);
		Customer customer = customerDao.getCustomerByCustomerID(node.get("customerID").toString());
		System.out.println(customer);

		return new Order(orderID, employeeID, customer, freight, shipName, requiredDate, requiredDate, orderDate, null);
	}

//	private String orderId;
//	private String employeeId;
//	private Customer customer;
//	private String shipCity;
//	private String freight;
//	private LocalDate requireDate;
//	private String shipName;
//	private String shipPostalCode;
//	private String shipCountry;
//	private String shipAddress;
//	private LocalDate shippedDate;
//	private LocalDate orderDate;
//	private String shipRegion;

}
