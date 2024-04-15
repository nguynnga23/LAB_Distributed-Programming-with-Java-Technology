package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.naming.NamingException;

import dao.PatientDao;
import dao.TreatmentDao;
import entity.Doctor;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
public class Client {
	public static void main(String[] args) throws NamingException, RemoteException, MalformedURLException, NotBoundException {
		PatientDao patientDao = (PatientDao) Naming.lookup("rmi://localhost:1792/patientDao");
		TreatmentDao treatmentDao = (TreatmentDao) Naming.lookup("rmi://localhost:1792/treatmentDao");
		
		List<Doctor> doctors = treatmentDao.getDoctorsByDepartmentReturnList("Dermatology");
		for (Doctor doctor : doctors) {
			System.out.println(doctor.toString());
		}
	}
}
