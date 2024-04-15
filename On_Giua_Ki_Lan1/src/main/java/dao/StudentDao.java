package dao;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Student;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class StudentDao {
	private Driver driver;
	private SessionConfig sessionConfig;

	public StudentDao(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	public void addStudent1(Student st) {
		String query = "CREATE (s : Student {studentID: $id, name: $name, gpa: $gpa}) ";
		Map<String, Object> pars = Map.of("id", st.getStudentId(), "name", st.getName(), "gpa", st.getGpa());

		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();

			});
		}
	}

	// Add
	public String addStudent(Student st) {
		String query = "CREATE (s:Student {studentID: $id, name: $name, gpa: $gpa}) "
				+ "RETURN s.studentID as studentID ";
		Map<String, Object> pars = Map.of("id", st.getStudentId(), "name", st.getName(), "gpa", st.getGpa());
		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return null;

				Record record = result.stream().findFirst().get();

				return record.get("studentID").asString();
			});
		}
	}

	// Find
	public Student findStudentByID(String studentID) {
		String query = "MATCH (s : Student) " + "WHERE s.studentID = $id " + "RETURN s ";

		Map<String, Object> pars = Map.of("id", studentID);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return null;
				Record record = result.stream().findFirst().get();
				Node node = record.get("s").asNode();
				return new Student(node.get("studentID").asString(), node.get("name").asString(),
						Float.parseFloat(node.get("gpa").toString()));
			});
		}
	}

	// Get list of students
	public List<Student> listOfStudents(int limit) {
		String query = "MATCH (s:Student) " + "RETURN s " + "LIMIT $limit ";
		Map<String, Object> pars = Map.of("limit", limit);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				return result.stream().map(record -> {
					Node node = record.get("s").asNode();
					return new Student(node.get("studentID").asString(), node.get("name").asString(),
							Float.parseFloat(node.get("gpa").toString()));
				}).toList();
			});
		}
	}

	// Update students's information
	public void updateStudent(Student st) {
		String query = "MERGE (s: Student {studentID: $id}) " + "SET s.name = $name, s.gpa = $gpa ";
		Map<String, Object> pars = Map.of("id", st.getStudentId(), "name", st.getName(), "gpa", st.getGpa());
		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}

	// Delete student by id
	public void deleteStudentById(String studentID) {
		String query = "MATCH (s:Student) " + "WHERE s.studentID = $id " + "DELETE s ";
		Map<String, Object> pars = Map.of("id", studentID);

		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}
	
	// Danh sách sinh viên có gpa >= 3.2, kết quả sắp xếp giảm dần theo gpa

	// Close the driver
	public void close() {
		driver.close();
	}

}
