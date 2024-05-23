package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import dao.CourseDao;
import dao.DepartmentDao;
import dao.StudentDao;
import dao.impl.CourseImpl;
import dao.impl.DepartmentImpl;
import dao.impl.StudentImpl;
import entity.Course;
import entity.Department;
import entity.OnsiteCourse;
import entity.Student;

/**
 * @author Nguyen Thi Nga
 * @date Apr 1, 2024
 */
public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(2222)) {
			System.out.println("Server is running on port 2222");
			while (true) {
				Socket client = server.accept();
				System.out.println("Client connected");
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client Port: " + client.getPort());
				Server temp = new Server();
				new Thread(temp.new ClientHandler(client)).start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ClientHandler implements Runnable {
		private static final Gson GSON = new Gson();
		private StudentDao studentDao;
		private DepartmentDao departmentDao;
		private CourseDao courseDao;
		
		private Socket socket;
		
		private Department dept;
		private int deptID;
		private List<Course> courses;

		public ClientHandler(Socket socket) {
			super();
			this.socket = socket;
			this.studentDao = new StudentImpl();
			this.departmentDao = new DepartmentImpl();
			this.courseDao = new CourseImpl();
		}

		@Override
		public void run() {
			try {
				DataInputStream in = new DataInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

				int choice = 0;
				while (true) {
					choice = in.readInt();
					switch (choice) {
					case 1:
						Map<Department, Long> map = departmentDao.countCoursesByDepartment();
						out.writeObject(map);
						break;

					case 2:
						String title = in.readUTF();
						System.out.println("Client requested to search for: " + title);
						List<Student> students = studentDao.findByEnrollmentInCourse(title);
						out.writeObject(students);
						break;
					case 3:
						List<OnsiteCourse> onsiteCourses = courseDao.findAllOnsiteCourses();
						out.writeObject(onsiteCourses);
						break;
					case 4:
						String name = in.readUTF();
						Double budget = in.readDouble();
						int administrator = in.readInt();
						dept = new Department(name, LocalDateTime.now(), budget, administrator);
						if (departmentDao.addDepartment(dept)) {
							out.writeObject("Add successfully!!!");
						} else {
							out.writeObject("Add unsuccessfully!!!");
						}
						break;

					case 5:
						deptID = in.readInt();
						dept = departmentDao.findById(deptID);
						dept.setName(in.readUTF());
						dept.setBudget(in.readDouble());
						dept.setAdministrator(in.readInt());
						dept.setStartDate(LocalDateTime.parse(in.readUTF()));
						if (departmentDao.updateDepartment(dept)) {
							out.writeObject("Update successfully!!!");
						} else {
							out.writeObject("Update unsuccessfully!!!");
						}
						break;

					case 6:
						if (departmentDao.deleteDepartment(deptID)) {
							out.writeObject("Delete successfully!!!");
						} else {
							out.writeObject("Delete unsuccessfully!!!");
						}
						break;
					case 7:
						courses = courseDao.findCoursesWithMaxCredits();
						out.writeObject(courses);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
