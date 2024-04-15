package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.*;

import dao.Calculator;
import dao.impl.CalculatorImpl;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public class Server {
	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		System.out.println("Server is running...");
		// create implemnt instant
		Calculator calc = new CalculatorImpl();
		// bin to server - use JNDI
		Context ctx = new InitialContext();
		// ctx.bind("rmi:met",calc);
		System.out.println("Server has bound to rmi://localhost:1099/Calculator");
	}
}
