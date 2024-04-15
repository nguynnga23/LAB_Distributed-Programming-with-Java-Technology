package dao.impl;

import dao.Calculator;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public class CalculatorImpl extends java.rmi.server.UnicastRemoteObject implements Calculator {
	public CalculatorImpl() throws java.rmi.RemoteException {
	}

	public int cong(int a, int b) throws java.rmi.RemoteException {
		return a + b;
	}

	public int tru(int a, int b) throws java.rmi.RemoteException {
		return a - b;
	}

	public int nhan(int a, int b) throws java.rmi.RemoteException {
		return a * b;
	}

	public int chia(int a, int b) throws java.rmi.RemoteException {
		return a / b;
	}
}