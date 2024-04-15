package client;

import java.io.*;
import java.net.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 28, 2024
 */
public class ClientSide {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;

	@SuppressWarnings("deprecation")
	public ClientSide(String address, int port) {
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");
			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}

		// String to read message from input
		String line = "";

		// keep reading until "End" is input
		while (!line.equals("End")) {
			try {
				line = input.readUTF();
				output.writeUTF(line);
			} catch (IOException i) {
				System.out.println(i);
			}
		}

		// close the connection
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		ClientSide client = new ClientSide("127.0.0.1", 5000);
	}

}
