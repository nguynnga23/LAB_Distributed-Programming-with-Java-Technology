package dao.impl;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.PositionDao;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */
class PositionImplTest {
	private PositionDao positionDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		positionDao = new PositionImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
