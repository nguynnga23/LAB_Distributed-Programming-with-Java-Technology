package dao.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.CandidateDao;
import entity.Candidate;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */
class CandidateImplTest {
	private CandidateDao candidateDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		candidateDao = new CandidateImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testListCadidatesByCompanies() {
		  // Gọi phương thức để lấy danh sách ứng viên theo công ty từ CandidateDao
        Map<Candidate, Long> candidatesByCompanies = candidateDao.listCadidatesByCompanies();

        // Kiểm tra xem danh sách có trống hay không
        assertFalse(candidatesByCompanies.isEmpty());

        // In ra danh sách để kiểm tra
        candidatesByCompanies.forEach((candidate, count) -> {
            System.out.println(candidate + " - " + count);
        });
	}

}
