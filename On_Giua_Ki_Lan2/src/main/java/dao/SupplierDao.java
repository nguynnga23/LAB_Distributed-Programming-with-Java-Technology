package dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Record;

import entity.Supplier;
import lombok.NoArgsConstructor;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
@NoArgsConstructor
public class SupplierDao {
	// Open the driver
	private Driver driver;
	private SessionConfig sessionConfig;

	public SupplierDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	
	// Close the driver
	public void close() {
		driver.close();
	}

	/**
	 * @param supplierID
	 * @return
	 */
	public Supplier getSupplierBySupplierID(String supplierID) {
		String query = "MATCH (s:Supplier) WHERE s.supplierID = $supplierID RETURN s";
		Map<String, Object> pars = Map.of("supplierID", supplierID);

		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				Record record = result.single();
				Node node = record.get("s").asNode();
				return AppUtil.nodeToSupplier(node);
			});
		}
	}
}
