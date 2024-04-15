package server;

import java.io.*;
import java.net.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 28, 2024
 */
public class Server_Process extends Thread {
	Socket socket;
	BufferedReader netIn;
	PrintWriter netOut;

	public Server_Process(Socket socket) throws IOException {
		this.socket = socket;
		try {
			netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		netOut.println("Hello Client");
		netOut.flush();
		while (true) {
			String command; 
			try {
				command = netIn.readLine();
				if (command.equalsIgnoreCase("Quit")) {
					netOut.println("Goodbye Client");
					netOut.flush();
					netIn.close();
					netOut.close();
					break;
				} else {
					netOut.println("Server response: " + command);
					netOut.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
