package server;

import java.io.*;
import java.net.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 28, 2024
 */
public class ServerSide {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;

	// contructor with port
	public ServerSide(int port) {
		//starts server and waits for a connection
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			System.out.println("Waiting for a client ...");
			socket = server.accept();
			System.out.println("Client accepted");
			
			//takes input from the client socket
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String line = "";
			//reads message from client until "End" is sent
			while(!line.equals("End")) {
                try {
                    line = input.readUTF();
                    System.out.println(line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
			System.out.println("Closing connection");
			socket.close();
			input.close();
			
		} catch (IOException i) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		ServerSide server = new ServerSide(5000);
	}
}
