package client;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import entity.Candidate;
import entity.Position;

/**
 * @author Nguyen Thi Nga
 * @date May 18, 2024
 */
public class Client_Lan1 {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 791); Scanner sc = new Scanner(System.in);) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectOutputStream outObject = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			int choice = 0;
			while (true) {
				System.out.println("\nEnter your choice : \n"
						+ "1. List of job positions when knowing the position name (relative search) and salary range, sorting results by job position name. \n"
						+ "2. List the candidates and the number of companies these candidates have worked for. \n"
						+ "3. Find a list of candidates who have worked for a certain job position for the longest time. \n"
						+ "4. Add a new candidate. The candidate code must start with C, followed by at least 3 digits. \n"
						+ "5. Calculate the number of years working in a certain job position when knowing the candidateId. \n"
						+ "6. List the list of candidates and the list of qualifications of each candidate. \n");
				choice = sc.nextInt();
				out.writeInt(choice); // Chuyền giá trị choice cho Server
				out.flush();

				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.println("Input name position: ");
					String name = sc.nextLine();
					out.writeUTF(name);
					out.flush();

					System.out.println("Salary From: ");
					double salaryFrom = sc.nextDouble();
					out.writeDouble(salaryFrom);
					out.flush();

					System.out.println("To: ");
					double salaryTo = sc.nextDouble();
					out.writeDouble(salaryTo);
					out.flush();
					System.out.println("Result : ");
					List<Position> positions = (List<Position>) in.readObject();
					positions.forEach(System.out::println);
					break;
				case 2:
					Map<Candidate, Long> resultCase2 = (Map<Candidate, Long>) in.readObject();
					Set<Entry<Candidate, Long>> mapCase2 = resultCase2.entrySet();
					for (Entry<Candidate, Long> entry : mapCase2) {
						System.out.println(entry);
					}
					break;
				case 3:
					Map<Candidate, Position> resultCase3 = (Map<Candidate, Position>) in.readObject();
					Set<Entry<Candidate, Position>> mapCase3 = resultCase3.entrySet();
					for (Entry<Candidate, Position> entry : mapCase3) {
						System.out.println(entry.getKey());
						System.out.println(entry.getValue());
					}
					break;
//					String id, String fullName, int yearOfBirth, String gender, String email, String phone,
//					String description
				case 4:
					sc.nextLine();
					System.out.println("Input id: ");
					String id = sc.nextLine();
//					out.writeUTF(id);
//					out.flush();
					
					sc.nextLine();
					System.out.println("Input fullname: ");
					String fullName = sc.nextLine();
//					out.writeUTF(fullName);
//					out.flush();
					
					System.out.println("Input Year Of Birth: ");
					int yearOfBirth = sc.nextInt();
//					out.writeInt(yearOfBirth);
//					out.flush();
					
					sc.nextLine();
					System.out.println("Input gender (Male/Female): ");
					String gender = sc.nextLine();
//					out.writeUTF(gender);
//					out.flush();
					
					sc.nextLine();
					System.out.println("Input email: ");
					String email = sc.nextLine();
//					out.writeUTF(email);
//					out.flush();
					
					sc.nextLine();
					System.out.println("Input phone: ");
					String phone = sc.nextLine();
//					out.writeUTF(phone);
//					out.flush();
					
					sc.nextLine();
					System.out.println("Input description: ");
					String des = sc.nextLine();
//					
					
					Candidate c = new Candidate(id, fullName, yearOfBirth, gender, email, phone, des);
					outObject.writeObject(c);
					outObject.flush();
					
					Boolean result = (Boolean) in.readObject();
					if(result) {
						System.out.println("Thêm thành công !!!");
					}else {
						System.out.println("Thêm thất bại !!!");
					}
					break;
				case 5:
					sc.nextLine();
					System.out.println("Input CandidateID : ");
					String candidateId = sc.nextLine();
					out.writeUTF(candidateId);
					out.flush();
					System.out.println("Result : ");
					Map<Position, Integer> resultCase5 = (Map<Position, Integer>) in.readObject();
					Set<Entry<Position, Integer>> mapCase5 = resultCase5.entrySet();
					for (Entry<Position, Integer> entry : mapCase5) {
						System.out.println(entry);
					}
					break;

				case 6:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
