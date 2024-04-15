package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Nguyen Thi Nga
 * @date Apr 1, 2024
 */
public class Server {
	public static void main(String[] args) throws RemoteException, NamingException {
		Context context = new InitialContext();
		
		CourseDao courseDao = new CourseImpl();
		StudentDao studentDao = new StudentImpl();
		DepartmentDao departmentDao = new DepartmentImpl();
		
		LocateRegistry.createRegistry(1791);
		context.bind("rmi://localhost:1791/courseDao", courseDao);
		context.bind("rmi://localhost:1791/studentDao", studentDao);
		context.bind("rmi://localhost:1791/departmentDao", departmentDao);
		
		System.out.println("Server is running on port 791");
	}
}
