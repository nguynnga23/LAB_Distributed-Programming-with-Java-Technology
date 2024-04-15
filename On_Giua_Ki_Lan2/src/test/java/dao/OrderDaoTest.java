package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Customer;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
class OrderDaoTest {
	private static final String DB_NAME = "neo4j";
	private OrderDao orderDao;
	private CustomerDao customerDao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		orderDao = new OrderDao(AppUtil.driverInit(), DB_NAME);
		customerDao = new CustomerDao(AppUtil.driverInit(), DB_NAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		orderDao.close();
	}
	
//	@Test
//	void testGetOrderByID() {
//		System.out.println(orderDao.getOrderByID("10248").toString());
//	}

	@Test
	void testGetOrdersByCustomers() {
		Set<Entry<Customer, Integer>> n = orderDao.getOrdersByCustomers().entrySet();
		for (Entry<Customer, Integer> entry : n) {
			System.out.println(entry);
			Customer c = customerDao.getCustomerByCustomerID("GREAL");
			System.err.println(c);
		}
		
		
		
		
	}

//	@Test
//	void testTotalAmountOfAnOrderByOrderDate() {
//		System.out.println(orderDao.totalAmountOfAnOrderByOrderDate("1996-08-16"));
//	}
//	
//	@Test
//	void testTotalAmountOfOrderByMonthAndYear() {
//		System.out.println(orderDao.totalAmountOfOrderByMonthAndYear(1996, 8));
//	}
}
