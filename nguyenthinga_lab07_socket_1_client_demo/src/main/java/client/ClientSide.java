package client;

import java.io.*;
import java.net.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 28, 2024
 */
public class ClientSide {
	BufferedReader netIn;
	PrintWriter netOut;
	Socket socket;
	BufferedReader userIn;

	public ClientSide() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 1111);
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	public void main_progress() throws IOException {
		String greeting = netIn.readLine();
		System.out.println(greeting);
		while (true) {
			userIn = new BufferedReader(new InputStreamReader(System.in));
			String command = userIn.readLine();
			netOut.println(command);
			netOut.flush();
			String response = netIn.readLine();
			System.out.println(response);
			if (response.equalsIgnoreCase("Goodbye Client")) {
				netIn.close();
				netOut.close();
				userIn.close();
				break;
			}
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new ClientSide().main_progress();
	}

}
