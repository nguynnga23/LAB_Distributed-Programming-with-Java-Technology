package server;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.CandidateDao;
import dao.PositionDao;
import dao.impl.CandidateImpl;
import dao.impl.PositionImpl;
import entity.Candidate;
import entity.Position;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */
public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(791)) {
			System.out.println("Server is running on port 791");
			while (true) {
				Socket client = server.accept();
				System.out.println("Client connected!");
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client port : " + client.getPort());
				Server temp = new Server();
				new Thread(temp.new ClientHandler(client)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ClientHandler implements Runnable {
		private CandidateDao candidateDao;
		private PositionDao positionDao;
		private Socket socket;

		public ClientHandler(Socket socket) {
			super();
			this.candidateDao = new CandidateImpl();
			this.positionDao = new PositionImpl();
			this.socket = socket;
		}

//		+ "1. Liệt kê danh sách các vị trí công việc khi biết tên vị trí (tìm tương đối) và mức lương khoảng từ, kết quả sắp xếp theo tên vị trí công việc. \n "
//		+ "2. Liệt kê danh sách các ứng viên và số công ty mà các ứng viên này từng làm. \n"
//		+ "3. Tìm danh sách các ứng viên đã làm việc trên một vị trí công việc nào đó có thời gian làm lâu nhất. \n"
//		+ "4. Thêm một ứng viên mới. Trong đó mã số ứng viên phải bắt đầu là C, theo sau ít nhất là 3 ký số. \n"
//		+ "5. Tính số năm làm việc trên một vị trí công việc nào đó khi biết mã số ứng viên. \n"
//		+ "6. Liệt kê danh sách cácứng viên và danh sách bằng cấpcủa từng ứng viên. \n");

		@Override
		public void run() {
			try {
				DataInputStream in = new DataInputStream(socket.getInputStream());
				ObjectInputStream inObject = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

				int choice = 0;
				while (true) {
					choice = in.readInt(); // Nhận ra giá trị từ Client
					switch (choice) {
					case 1:
						String name = in.readUTF();
						double salaryFrom = in.readDouble();
						double salaryTo = in.readDouble();
						List<Position> positions = positionDao.listPositions(name, salaryFrom, salaryTo);
						out.writeObject(positions);
						break;
					case 2:
						Map<Candidate, Long> resultCase2 = candidateDao.listCadidatesByCompanies();
						out.writeObject(resultCase2);
						break;
					case 3:
						Map<Candidate, Position> resultCase3 = candidateDao.listCandidatesWithLongestWorking();
						out.writeObject(resultCase3);
						break;
					case 4:
						Candidate c = (Candidate) inObject.readObject();
						Boolean resultCase4 = candidateDao.addCandidate(c);
						out.writeBoolean(resultCase4);
						break;
					case 5:
						String candidateId = in.readUTF();
						Map<Position, Integer> resultCase5 = positionDao.listYearsOfExperienceByPosition(candidateId);
						out.writeObject(resultCase5);
						break;
					case 6:
						break;
					}
				}
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
