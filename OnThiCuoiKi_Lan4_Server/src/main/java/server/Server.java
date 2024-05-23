package server;

import java.awt.Choice;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import dao.BookDao;
import dao.BookTranslationDao;
import dao.ReviewsDao;
import dao.impl.BookImpl;
import dao.impl.BookTranslationImpl;
import dao.impl.ReviewsImpl;
import entity.Book;

/**
 * @author Nguyen Thi Nga
 * @date May 20, 2024
 */
public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(791)) {
			System.out.println("Server is running on port 791");
			while (true) {
				Socket client = server.accept();
				System.out.println("Client connected");
				Server temp = new Server();
				new Thread(temp.new ClientHandler(client)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class ClientHandler implements Runnable {
		private BookDao bookDao;
		private BookTranslationDao booktranslationDao;
		private ReviewsDao reviewsDao;
		private Socket socket;

		public ClientHandler(Socket socket) {
			this.socket = socket;
			this.bookDao = new BookImpl();
			this.booktranslationDao = new BookTranslationImpl();
			this.reviewsDao = new ReviewsImpl();
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
						String author = in.readUTF();
						int rating = in.readInt();
						List<Book> books = bookDao.listRatedBooks(author, rating);
						out.writeObject(books);
						break;
					case 2:
						Map<String, Long> result = booktranslationDao.countBooksByAuthor();
						out.writeObject(result);
						break;
					case 3:
						break;

					default:
						throw new IllegalArgumentException("Unexpected value: " + choice);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
