package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import entity.Food;
import entity.Item;
import entity.Type;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
public class Client_Lan2 {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 791); Scanner sc = new Scanner(System.in)) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			int choice = 0;
			while (true) {
				System.out.println("\n Enter your choice : \n" + "1. Add food \n" + "2. List Items \n"
						+ "3. List Food and Cost \n");
				choice = sc.nextInt();
				out.writeInt(choice);
				out.flush();
				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.println("Input food id : ");
					String id = sc.nextLine();
					out.writeUTF(id);
					out.flush();

//					sc.nextLine();
					System.out.println("Input food name : ");
					String name = sc.nextLine();
					out.writeUTF(name);
					out.flush();

					System.out.println("Input food price : ");
					double price = sc.nextDouble();
					out.writeDouble(price);
					out.flush();

					sc.nextLine();
					System.out.println("Input food description : ");
					String description = sc.nextLine();
					out.writeUTF(description);
					out.flush();

					System.out.println("Input food onSpecial : ");
					boolean onSpecial = sc.nextBoolean();
					out.writeBoolean(onSpecial);
					out.flush();

					sc.nextLine();
					System.out.println("Input food type : ");
					String type = sc.nextLine();
					out.writeUTF(type);
					out.flush();
					
					sc.nextLine();
					System.out.println("Input food preparationTime : ");
					int preparationTime = sc.nextInt();
					out.writeInt(preparationTime);
					out.flush();

					System.out.println("Input food servingTime : ");
					int servingTime = sc.nextInt();
					out.writeInt(servingTime);
					out.flush();

					Food f = (Food) in.readObject();
					System.out.println(f);
					break;
				case 2:
					sc.nextLine();
					System.out.println("Input Supplier Name : ");
					String supplierName = sc.nextLine();
					out.writeUTF(supplierName);
					out.flush();

					@SuppressWarnings("unchecked")
					List<Item> list = (List<Item>) in.readObject();
					for (Item item : list) {
						System.out.println(item);
					}
					break;
				case 3:
					@SuppressWarnings("unchecked")
					Map<Food, Double> map = (Map<Food, Double>) in.readObject();
					Set<Entry<Food, Double>> result = map.entrySet();
					for (Entry<Food, Double> entry : result) {
						System.out.println(entry.getKey().getName() + "=" + entry.getValue());
					}
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
