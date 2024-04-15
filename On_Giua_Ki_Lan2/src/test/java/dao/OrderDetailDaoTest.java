package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.OrderDetail;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
class OrderDetailDaoTest {
	private static final String DB_NAME = "neo4j";
	private OrderDetailDao orderDetailDao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		orderDetailDao = new OrderDetailDao(AppUtil.driverInit(), DB_NAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		orderDetailDao.close();
	}

	@Test
	void testsumMoneyOfOrderByID() {
		System.err.println("Test TestsumMoneyOfOrderByID()");
		Set<Entry<String, Double>> n = orderDetailDao.sumMoneyOfOrderByID("10250").entrySet();
		for (Entry<String, Double> entry : n) {
			System.out.println("OrderID: " + entry.getKey());
			System.out.println("Sum of price: " + entry.getValue());
		}
	}
	
	

}
