package dao;

import java.util.List;
import java.util.Map;

import entity.Department;
import jakarta.persistence.EntityManager;

/**
 * @author Nguyen Thi Nga
 * @date Apr 1, 2024
 */
public interface DepartmentDao extends java.rmi.Remote {

	public void close() throws java.rmi.RemoteException;

	public boolean addDepartment(Department department) throws java.rmi.RemoteException;

	public boolean updateDepartment(Department department) throws java.rmi.RemoteException;

	public boolean deleteDepartment(int id) throws java.rmi.RemoteException;

	public List<Department> findAll() throws java.rmi.RemoteException;

	public Department findById(int id) throws java.rmi.RemoteException;

	public List<Department> findByName(String name) throws java.rmi.RemoteException;

	public Map<Department, Long> countCoursesByDepartment() throws java.rmi.RemoteException;

}
