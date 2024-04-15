package dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Record;

import entity.Product;

public class ProductDao {
	private Driver driver;
	private SessionConfig sessionConfig;

	public ProductDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	// Add
	public String addProduct(Product p) {
		String query = "";
		Map<String, Object> pars = Map.of();
		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, pars);
				Record record = result.stream().findFirst().get();
				return record.get("categoryID").asString();
			});
		}
	}
	// Delete
	// Update
	// Find

}
