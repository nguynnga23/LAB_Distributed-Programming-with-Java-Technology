package dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.types.Node;
import util.AppUtil;
import entity.Category;
import lombok.NoArgsConstructor;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
@NoArgsConstructor
public class CategoryDao {
	// Open the driver
	private Driver driver;
	private SessionConfig sessionConfig;
	
	public CategoryDao(Driver driver, String dbName) {
		super();
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	// Close the driver
	public void close() {
		driver.close();
	}
	// Add a new category
	public void addCategory(Category category) {
		String query = "CREATE (c:Category {categoryID: $categoryID, categoryName: $categoryName})";
		Map<String, Object> pars = AppUtil.getProperties(category);
		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			
			});
		}
	}
	// Get a category by categoryID
	public Category getCategoryByCategoryID(String categoryID) {
		String query = "MATCH (c:Category) WHERE c.categoryID = $categoryID RETURN c";
		Map<String, Object> pars = Map.of("categoryID", categoryID);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				Record record = result.single();
				Node node = record.get("c").asNode();
				Category category = AppUtil.nodeToPOJO(node, Category.class);
				return category;
			});
		}
	}
	
	public static void main(String[] args) {
		Driver driver = AppUtil.driverInit();
		CategoryDao categoryDao = new CategoryDao(driver, "neo4j");
		Category category = new Category("0", "Nga", "Nga nga nga", "cnjncjxncjuidabchjbvub");
		categoryDao.addCategory(category);
		Category category2 = categoryDao.getCategoryByCategoryID("0");
		System.out.println(category2);
		categoryDao.close();
	}
}
