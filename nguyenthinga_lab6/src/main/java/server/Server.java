package server;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.CourseDao;
import dao.DepartmentDao;
import dao.StudentDao;
import dao.impl.CourseImpl;
import dao.impl.DepartmentImpl;
import dao.impl.StudentImpl;
import entity.Department;
import entity.OnsiteCourse;
import entity.Student;

public class Server {
	public static void main(String[] args) {
		
		try(ServerSocket server = new ServerSocket(7878);
				){
			
			System.out.println("Server started on port 7878");
			
			while (true) {
				Socket client = server.accept();
				
				System.out.println("Client connected"	);
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client Port: " + client.getPort());
				
				Thread t = new Thread(new ClientHandler(client));
				t.start();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class ClientHandler implements Runnable{
	private Socket socket;
	private StudentDao studentDao;
	private DepartmentDao departmentDao;
	private CourseDao courseDao;

	public ClientHandler(Socket client) {
		super();
		this.socket = client;
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
			
			while(true) {
				choice = in.readInt();
				switch(choice) {
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
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}