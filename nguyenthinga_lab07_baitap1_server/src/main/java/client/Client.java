package client;

import java.rmi.RemoteException;

import javax.naming.*;

import dao.Calculator;

/**
 * @author Nguyen Thi Nga
 * @date Apr 7, 2024
 */
public class Client {
	public static void main(String[] args) throws NamingException, RemoteException {
		String svr = "localhost";
		if (args.length > 0) {
			svr = args[0];
		}

		Context ctx = new InitialContext();
		Object obj = ctx.lookup("rmi://" + svr + ":1099/Calculator");
		Calculator calc = (Calculator) obj;

		// calling method
		int c1 = calc.cong(3, 6);
		int c2 = calc.tru(3, 6);
		int c3 = calc.chia(3, 6);

		// processing results
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

	}
}
