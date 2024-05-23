package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.FoodDao;
import dao.ItemDao;
import dao.impl.FoodImpl;
import dao.impl.ItemImpl;
import entity.Food;
import entity.Item;
import entity.Type;

/**
 * @author Nguyen Thi Nga
 * @date May 20, 2024
 */
public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(791)) {
			System.out.println("Server is running on port 791!!!");
			while (true) {
				Socket client = server.accept();
				System.out.println("Client connected");
				Server temp = new Server();
				new Thread(temp.new ClientHandler(client)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class ClientHandler implements Runnable {
		private FoodDao foodDao;
		private ItemDao itemDao;
		private Socket socket;

		public ClientHandler(Socket socket) {
			this.foodDao = new FoodImpl();
			this.itemDao = new ItemImpl();
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				DataInputStream in = new DataInputStream(socket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				int choice = 0;
				while (true) {
					choice = in.readInt();
					switch(choice) {
					case 1:
//						Food f = new Food("F100", "Pho", 25.0, "Pho bo", false, Type.MAIN_COURSE, 10, 5);
						String id = in.readUTF();
						String name = in.readUTF();
						double price = in.readDouble();
						String description = in.readUTF();
						boolean onSpecial = in.readBoolean();
						String type = in.readUTF();
						int preparationTime = in.readInt();
						int servingTime = in.readInt();
						
						Food f = new Food(id, name, price, description, onSpecial, Type.valueOf(type), preparationTime, servingTime);
                        boolean result1 = foodDao.addFood(f);
						if (result1) {
							out.writeObject(f);
						} else {
							System.out.println("Add food failed");
						}
						break;
					case 2:
						String supplierName = in.readUTF();
						List<Item> items = itemDao.listItems(supplierName);
						out.writeObject(items);
						break;
					case 3:
						Map<Food, Double> result = foodDao.listFoodAndCost();
						out.writeObject(result);
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
