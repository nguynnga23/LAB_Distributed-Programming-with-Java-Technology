package client;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

/**
 * @author Nguyen Thi Nga
 * @date Mar 28, 2024
 */
public class ClientSide {
	Socket socket;
	DataInputStream netIn;
	DataOutputStream netOut;
	BufferedReader userIn;
	BufferedInputStream bis;

	public ClientSide() {
		try {
			socket = new Socket("localhost", 1234);
			netIn = new DataInputStream(socket.getInputStream());
			netOut = new DataOutputStream(socket.getOutputStream());
			String greeting = netIn.readUTF();
			System.out.println(greeting);
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException i) {
            i.printStackTrace();
        }
	}
	
	public void upload() {
		userIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			String command = userIn.readLine();
			StringTokenizer tokenizer = new StringTokenizer(command);
			String request = tokenizer.nextToken();
			String sourceFile = tokenizer.nextToken();
			String destFile = tokenizer.nextToken();
			File fileSource = new File(sourceFile);
			if (!fileSource.exists()) {
				netOut.writeUTF("File not found");
				netOut.flush();
				return;
			}else {
				netOut.writeUTF("File check OK");
				netOut.flush();
				netOut.writeUTF(destFile);
				netOut.flush();
				netOut.writeLong(fileSource.length());
				netOut.flush();
				bis = new BufferedInputStream(new FileInputStream(fileSource));
				int data;
				byte[] buffer = new byte[100*1024];
				while((data = bis.read(buffer)) != -1) {
					netOut.write(buffer, 0, data);
				}
				System.out.println(netIn.readUTF());
				netOut.close();
				netIn.close();
				bis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ClientSide().upload();
	}
}
