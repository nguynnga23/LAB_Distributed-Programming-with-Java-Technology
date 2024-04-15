package dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.Record;

import entity.Course;
import entity.Department;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class EnrollmentDao {
	// Kết nối với cơ sở dữ liệu
	private Driver driver;
	private SessionConfig sessionConfig;

	public EnrollmentDao(Driver driver, String dbName) {
		super();
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	//	Liệt kê danh sách các tên của các sinh viên đăng ký học khóa học CS101
	
	
}
