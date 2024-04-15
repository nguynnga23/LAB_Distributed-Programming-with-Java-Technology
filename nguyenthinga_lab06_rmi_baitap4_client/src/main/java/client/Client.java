package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.CourseDao;
import dao.DepartmentDao;
import dao.StudentDao;
import entity.Course;
import entity.Department;
import entity.OnsiteCourse;
import entity.Student;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		CourseDao courseDao = (CourseDao) Naming.lookup("rmi://localhost:1791/courseDao");
		StudentDao studentDao = (StudentDao) Naming.lookup("rmi://localhost:1791/studentDao");
		DepartmentDao departmentDao = (DepartmentDao) Naming.lookup("rmi://localhost:1791/departmentDao");
		
		departmentDao.findAll().forEach(System.out::println);
		
	}
}
