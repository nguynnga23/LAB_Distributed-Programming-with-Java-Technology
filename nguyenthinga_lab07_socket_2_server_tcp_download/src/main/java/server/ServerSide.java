package server;

import java.io.*;
import java.net.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 28, 2024
 */
public class ServerSide {
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream netIn;
	DataOutputStream netOut;
	BufferedOutputStream bos;

	public ServerSide() {
		System.out.println("Waiting for client...");
		try {
			serverSocket = new ServerSocket(1234);
			socket = serverSocket.accept();
			netIn = new DataInputStream(socket.getInputStream());
			netOut = new DataOutputStream(socket.getOutputStream());
			System.out.println("Connected to client");
			netOut.writeUTF("Hello Client");
			netOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Cú pháp upload
	// upload D:\TOEIC\toeic.pdf D:\ upload_file.pdf

	public void download() throws IOException {
		String command = netIn.readUTF();
		if (command.equalsIgnoreCase("File check OK")) {
			String dest = netIn.readUTF();
			System.err.println(dest);
			long size = netIn.readLong();
			System.err.println(size);
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			int byteReaded = 0;
			int data;
			byte[] buffer = new byte[100 * 1024];
			while (byteReaded < size) {
				data = netIn.read(buffer);
				bos.write(buffer, 0, data);
				byteReaded += data;
			}
			netOut.writeUTF("Download success");
			netIn.close();
			netOut.close();
			bos.close();

		}
	}

	public static void main(String[] args) throws IOException {
		new ServerSide().download();
	}
}
