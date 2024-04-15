package dao;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public interface Calculator extends java.rmi.Remote {
	int cong(int a, int b) throws java.rmi.RemoteException;

	int tru(int a, int b) throws java.rmi.RemoteException;

	int nhan(int a, int b) throws java.rmi.RemoteException;

	int chia(int a, int b) throws java.rmi.RemoteException;
}
