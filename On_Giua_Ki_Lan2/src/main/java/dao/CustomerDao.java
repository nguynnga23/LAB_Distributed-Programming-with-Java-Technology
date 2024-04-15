package dao;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Customer;
import lombok.NoArgsConstructor;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
@NoArgsConstructor
public class CustomerDao {
	// Open the driver
	private Driver driver;
	private SessionConfig sessionConfig;
	//Close the driver
	public void close() {
		driver.close();
	}

	public CustomerDao(Driver driver, String dbName) {
		super();
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}
	
	public Customer getCustomerByCustomerID(String customerID) {
		String query = "MATCH (c:Customer) WHERE c.customerID = $customerID RETURN c";
		Map<String, Object> pars = Map.of("customerID", customerID);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				Node node = result.single().get("c").asNode();
				return AppUtil.nodeToCustomer(node);
			});
		}
	}
//	Thống kê số khách hàng theo từng thành phố (sắp xếp theo số khách hàng / theo city).
//	+ getNumberCustomerByCity() : Map<String, Integer>

	public Map<String, Integer> getNumberCustomerByCity() {
		String query = "MATCH(c:Customer)\r\n" + "WITH c.city as city, count(c.customerID) as count\r\n"
				+ "RETURN city, count";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream().collect(Collectors.toMap(record -> record.get("city").asString(),
						record -> record.get("count").asInt()));
			});
		}
	}
	

	

}
