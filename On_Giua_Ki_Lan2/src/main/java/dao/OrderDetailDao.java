package dao;

import java.util.Map;
import java.util.stream.Collectors;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
public class OrderDetailDao {
	// Open the driver
	private Driver driver;
	private SessionConfig sessionConfig;

	public OrderDetailDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	// Close the driver
	public void close() {
		driver.close();
	}

	// Tính tổng tiền của đơn hàng khi biết mã số đơn hàng.
	// SUM(unitPrice * quantity) - SUM(unitPrice * quantity) * discount
	public Map<String, Double> sumMoneyOfOrderByID(String orderID) {
		String query = "MATCH (o:Order)-[r:ORDERS]->(p:Product)\r\n"
				+ "WHERE o.orderID = $orderID \r\n"
				+ "WITH o, sum(r.quantity * p.unitPrice * (1 - toFloat(r.discount))) AS totalPrice\r\n"
				+ "RETURN o.orderID AS orderID, totalPrice";
		Map<String, Object> pars = Map.of("orderID", orderID);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, pars);
				return result.stream().collect(Collectors.toMap(record -> record.get("orderID").asString(),
						record -> record.get("totalPrice").asDouble()));
			});
		}
	}
	
	

}
