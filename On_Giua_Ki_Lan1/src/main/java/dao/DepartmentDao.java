package dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

import entity.Course;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class DepartmentDao {
	// Kết nối với cơ sở dữ liệu
	private Driver driver;
	private SessionConfig sessionConfig;

	public DepartmentDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();

	}

	// Get the number of students in a department
	public Map<String, Long> getNumOfStudentsByDept() {
		String query = "MATCH (dept:Department)<-[:BELONGS_TO]-(course:Course)<-[:ENROLLED]-(student:Student) "
				+ "RETURN dept.deptID as department_id, count(student) as total_students ";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				return tx.run(query).stream().collect(Collectors.toMap(record -> record.get("department_id").asString(),
						record -> record.get("total_students").asLong()));
			});
		}

	}

	// Tìm danh sách khóa học (Course) thuộc của một khoa nào đó khi biết mã khoa
	public Map<String, Object> getCourseBelongsToDept(String maKhoa){
		String query = "MATCH(d:Department)<-[:BELONGS_TO]-(c:Course) "
				+ "WHERE d.deptID = $id "
				+ "RETURN d.deptID as deptId, c as course ";
		Map<String, Object> pars = Map.of("id", maKhoa);
		try(Session session = driver.session(sessionConfig)){
			return session.executeRead(tx -> {
				return tx.run(query, pars).stream().collect(Collectors.toMap(record -> record.get("deptId").asString(),
						record -> record.get("course")));
			});
		}
	}

	// Liệt kê danh sách tên của các trưởng khoa mà các khoa này không có sinh viên
	// đăng ký học
	// Danh sách khoa có số sinh viên đăng ký học nhiều nhất

}
