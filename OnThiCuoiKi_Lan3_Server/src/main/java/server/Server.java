package server;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.DoctorDao;
import dao.PatientDao;
import dao.impl.DoctorImpl;
import dao.impl.PatientImpl;
import entity.Doctor;

/**
 * @author Nguyen Thi Nga
 * @date May 23, 2024
 */
public class Server {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(791)) {
			System.out.println("Server is listening on port 791");
			Socket client = serverSocket.accept();
			System.out.println("New client connected");
			Server temp = new Server();
			new Thread(temp.new ClientHandler(client)).start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private class ClientHandler implements Runnable {
		private Socket socket;
		private DoctorDao doctorDao;
		private PatientDao patientDao;

		public ClientHandler(Socket socket) {
			this.socket = socket;
			this.doctorDao = new DoctorImpl();
			this.patientDao = new PatientImpl();
		}

		@Override
		public void run() {
			try {
				DataInputStream in = new DataInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				int choice = 0;
				while (true) {
					choice = in.readInt();
					switch (choice) {
					case 1:
						String deptName = in.readUTF();
						List<Doctor> doctors = doctorDao.getDoctorsByDepartment(deptName);
						out.writeObject(doctors);
						break;
					case 2:
						Map<Doctor, Long> map = doctorDao.getNoTreatmentsByDoctors(in.readInt(), in.readInt());
						out.writeObject(map);
						break;
					case 3:
						break;
					default:
						break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
