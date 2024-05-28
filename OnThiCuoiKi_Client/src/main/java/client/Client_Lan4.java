package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import entity.Book;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
public class Client_Lan4 {
	public static void main(String[] args) {
		try (Socket client = new Socket("localhost", 791); Scanner sc = new Scanner(System.in);) {
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			int choice = 0;
			while (true) {
				System.out.println("\n Input your choice: \n" + "1. List rated book \n" + "2. Count books by author\n"
						+ "3. Update reviews \n");
				choice = sc.nextInt();
				out.writeInt(choice);
				out.flush();
				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.println("Input author :");
					String author = sc.nextLine();
					out.writeUTF(author);
					out.flush();
					System.out.println("Input rating :");
					int rating = sc.nextInt();
					out.writeInt(rating);
					out.flush();

					@SuppressWarnings("unchecked")
					List<Book> books = (List<Book>) in.readObject();
					for (Book book : books) {
						System.out.println(book.toString());
					}
					break;
				case 2:
					@SuppressWarnings("unchecked")
					Map<String, Long> map = (Map<String, Long>) in.readObject();
					Set<Entry<String, Long>> result = map.entrySet();
					for (Entry<String, Long> entry : result) {
						System.out.println(entry.getKey() + "=" + entry.getValue());
					}
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
