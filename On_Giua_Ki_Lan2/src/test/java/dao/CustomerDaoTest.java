package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
class CustomerDaoTest {
	private static final String DB_NAME = "neo4j";
	private CustomerDao customerDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		customerDao = new CustomerDao(AppUtil.driverInit(), DB_NAME);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		customerDao.close();
	}

	@Test
	void testgetNumberCustomerByCity() {
		System.err.println("Test getNumberCustomerByCity()");
		Set<Entry<String, Integer>> n = customerDao.getNumberCustomerByCity().entrySet();
		for (Entry<String, Integer> entry : n) {
			System.out.println(entry);
		}
	}

}
