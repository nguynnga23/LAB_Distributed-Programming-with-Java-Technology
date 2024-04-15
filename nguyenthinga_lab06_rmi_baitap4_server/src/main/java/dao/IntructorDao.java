package dao;

import java.util.List;

import entity.Instructor;

/**
 * @author Nguyen Thi Nga
 * @date Apr 3, 2024
 */
public interface IntructorDao extends java.rmi.Remote {
	public void close() throws java.rmi.RemoteException;

	public boolean addInstructor(Instructor instructor) throws java.rmi.RemoteException;

	public boolean updateInstructor(Instructor instructor) throws java.rmi.RemoteException;

	public boolean deleteInstructor(int id) throws java.rmi.RemoteException;

	public List<Instructor> findAll() throws java.rmi.RemoteException;

	public Instructor findById(int id) throws java.rmi.RemoteException;

	public List<Instructor> findByName(String name) throws java.rmi.RemoteException;

}
