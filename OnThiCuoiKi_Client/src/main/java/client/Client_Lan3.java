package client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.Doctor;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
public class Client_Lan3 {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 791); Scanner sc = new Scanner(System.in)) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			int choice = 0;
			while (true) {
				System.out
						.println("\n Select your choice : " + "1.getDoctorsByDepartment(deptName: String): List<Doctor>"
								+ "2.getNoTreatmentsByDoctors (int month, int year) : Map<Doctor, Integer>"
								+ "3.Add patient(Patient patient): boolean");
				choice = sc.nextInt();
				out.writeInt(choice);

				switch (choice) {
				case 1:
					sc.nextLine();
					System.out.println("Enter department name: ");
					String deptName = sc.nextLine();
					out.writeUTF(deptName);

					List<Doctor> doctors = (List<Doctor>) in.readObject();
					for (Doctor doctor : doctors) {
						System.out.println(doctor);
					}
					break;
				case 2:
					System.out.println("Enter month: ");
					int month = sc.nextInt();
					out.writeInt(month);
					out.flush();
					System.out.println("Enter year: ");
					int year = sc.nextInt();
					out.writeInt(year);
					out.flush();

					Map<Doctor, Long> map = (Map<Doctor, Long>) in.readObject();
					for (Doctor doctor : map.keySet()) {
						System.out.println(doctor + " : " + map.get(doctor));
					}
					break;
				case 3:
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
