package dao;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import entity.Course;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 1, 2024
 */
public class CourseDao {
	//Open the driver
	private Driver driver;
	private SessionConfig sessionConfig;

	public CourseDao(Driver driver, String dbName) {
		super();
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	// DAO_CourseDao_Add : addCourse(Course c) : String
	public String addCourse(Course c) {
		String query = "CREATE (c:Course {courseID: $id, hours: $hours, name: $name}) "
				+ "RETURN c.courseID as courseID ";
		Map<String, Object> pars = Map.of("id", c.getCourseId(), "hours", c.getHours(), "name", c.getName());
		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return null;
				Record record = result.stream().findFirst().get();
				return record.get("courseID").asString();
			});
		}
	}

//	DAO_CourseDao_Find course by id : findStudentByID(String studentID : Course

	
	public Course findCourseByID(String courseID) {
		String query = "MATCH(c:Course) " + "WHERE c.courseID = $id " + "RETURN c";
		Map<String, Object> pars = Map.of("id", courseID);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return null;
				Record record = result.stream().findFirst().get();
				Node node = record.get("c").asNode();
				Course c = AppUtil.nodeToPOJO(node, Course.class);
				return c;
			});
		}
	}

	// DAO_CourseDao_Get list of courses : listOfCourses(int limit) : List<Course>
	public List<Course> listOfCourses(int limit) {
		String query = "MATCH(c:Course) " + "RETURN c " + "LIMIT $limit";
		Map<String, Object> pars = Map.of("limit", limit);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				return result.stream().map(record -> {
					Node node = record.get("c").asNode();
					return new Course(Integer.parseInt(node.get("hours").toString()), node.get("name").asString(),
							node.get("courseID").asString());
				}).toList();
			});
		}
	}

	// DAO_CourseDao_Update course's information : updateCourse(Course course):void
	public void updateCourse(Course c) {
		String query = "MERGE(c:Course{courseID:$id})\r\n" + "SET c.hours=$hours, c.name=$name, c.courseID=$id ";
		Map<String, Object> pars = Map.of("hours", c.getHours(), "name", c.getName(), "id", c.getCourseId());
		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}

	// DAO_CourseDao_Add_Delete course by id : deleteCourseById(String CourseID)
	public void deleteCourseById(String courseID) {
		String query = "MATCH(c:Course) " + "WHERE c.courseID=$id " + "DELETE c ";
		Map<String, Object> pars = Map.of("id", courseID);
		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}
	
	//Close the driver
	public void close() {
		driver.close();
	}
}
