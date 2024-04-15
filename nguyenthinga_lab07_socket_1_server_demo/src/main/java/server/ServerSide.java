package server;

import java.io.*;
import java.net.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 28, 2024
 */
public class ServerSide {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(1111);
		System.out.println("Waiting for client to connect...");
		while(true) {
			Socket socket = serverSocket.accept();
			new Server_Process(socket).start();
			System.out.println("Client " + socket.getInetAddress() + " connected");
		}
	}
}
