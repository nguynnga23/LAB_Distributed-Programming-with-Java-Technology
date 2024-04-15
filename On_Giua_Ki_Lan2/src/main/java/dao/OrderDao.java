package dao;

import java.util.Map;
import java.util.stream.Collectors;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.Record;
import entity.Customer;
import entity.Order;
import lombok.NoArgsConstructor;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
@NoArgsConstructor
public class OrderDao {
	// Open the driver
	private Driver driver;
	private SessionConfig sessionConfig;

	// Close the driver
	public void close() {
		driver.close();
	}

	public OrderDao(Driver driver, String dbName) {
		super();
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}
	
	public Order getOrderByID(String orderId) {
		String query = "MATCH (o:Order) WHERE o.orderID = $id RETURN o";
		Map<String, Object> pars = Map.of("id", orderId);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return null;
				return AppUtil.nodeToOrder(result.single().get("o").asNode());
			});
		}
	}

//	6. Đếm số đơn hàng của từng khách hàng.
//	+ getOrdersByCustomers() : Map<Customer, Integer>
	public Map<Customer, Integer> getOrdersByCustomers() {
		String query = "MATCH(c:Customer)-[:PURCHASED]->(o:Order)\r\n"
				+ "RETURN c AS Customer, count(o) AS CountOfOrder\r\n" + "ORDER BY CountOfOrder";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream().collect(Collectors.toMap(record -> {
					Node cusRecord = record.get("Customer").asNode();
					return AppUtil.nodeToCustomer(cusRecord);
				}, record -> record.get("CountOfOrder").asInt()));
			});
		}
	}

//	9. Tính tổng tiền của tất cả các hóa đơn trong một ngày nào đó.
//	MATCH (o:Order)-[r:ORDERS]->(p:Product)
//	WHERE o.orderDate= datetime("1996-08-16")
//			WITH o, sum(r.quantity * toFloat(r.unitPrice) * (1 - toFloat(r.discount))) AS totalPrice
//			RETURN sum(totalPrice)
	/**
	 * Get the total amount of an order by orderDate Tính tổng số tiền của một đơn
	 * hàng khi biết orderDate MATCH (o:Order)-[r:ORDERS]->(p:Product) where
	 * o.orderDate= datetime("1996-07-10T00:00:00Z") RETURN
	 * sum(toFloat(r.unitPrice)*r.quantity) as totalAmount
	 * 
	 * @param orderDate
	 * @return
	 */
	
	//Update order date from String to Datetime
	//Chạy script sau để cập nhật cột orderDate và requiredDate về kiểu datetime

//		LOAD CSV WITH HEADERS FROM "https://data.neo4j.com/northwind/orders.csv" AS row
//		MERGE (n:Order {orderID:row.orderID})
//		SET n.orderDate=datetime(replace(row.orderDate,' ','T')),
//		n.orderDate=datetime(replace(row.requiredDate,' ','T'))

	public double totalAmountOfAnOrderByOrderDate(String orderDate) {
		String query = "MATCH (o:Order)-[r:ORDERS]->(p:Product)\r\n" + "WHERE o.orderDate= datetime($date)\r\n"
				+ "WITH o, sum(r.quantity * toFloat(r.unitPrice) * (1 - toFloat(r.discount))) AS totalPrice\r\n"
				+ "RETURN sum(totalPrice) as totalAmount";
		Map<String, Object> pars = Map.of("date", orderDate);

		try (Session session = driver.session()) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return 0.0;
				return result.single().get("totalAmount").asDouble();
			});
		}
	}
	
	public double totalAmountOfOrderByMonthAndYear(int year, int month) {
		String query = "MATCH (o:Order)-[r:ORDERS]->(p:Product)\r\n"
				+ "WHERE o.orderDate.year = $year AND o.orderDate.month = $month "
				+ "RETURN sum(r.quantity * toFloat(r.unitPrice) * (1 - toFloat(r.discount))) as totalAmount ";
		Map<String, Object> pars = Map.of("year", year, "month", month);
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if(!result.hasNext())
					return 0.0;
				return result.single().get("totalAmount").asDouble();
			});
		}
	}
}
