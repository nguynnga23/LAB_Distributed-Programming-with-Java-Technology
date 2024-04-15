package dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Values;

import entity.Category;
import entity.Product;

public class CategoryDao {
	private Driver driver;
	private SessionConfig sessionConfig;
	public CategoryDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}
	

	// Add a category
	public Category addCategory(Category category) {
		String query = "CREATE(c:Category{description: $description,"
				+ "categoryName: $categoryName,"
				+ "picture: $picture,"
				+ "categoryID: $categoryID})"
				+ "RETURN c";
		Map<String, Object> pars = Map.of();
		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, Values.parameters("id", id));
				Record record = result.asNode();
//				return record.get("categoryID").asString();
			});
		}
	}
	
	

}
