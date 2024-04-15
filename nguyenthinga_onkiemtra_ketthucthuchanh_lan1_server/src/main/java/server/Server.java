package server;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.registry.LocateRegistry;
import dao.PatientDao;
import dao.TreatmentDao;
import dao.impl.PatientImpl;
import dao.impl.TreatmentImpl;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
public class Server {
	public static void main(String[] args) throws NamingException, RemoteException {
		Context context = new InitialContext();

		PatientDao patientDao = new PatientImpl();
		TreatmentDao treatmentDao = new TreatmentImpl();

		LocateRegistry.createRegistry(1792);
		context.bind("rmi://localhost:1792/patientDao", patientDao);
		context.bind("rmi://localhost:1792/treatmentDao", treatmentDao);
		System.out.println("Server is running on port 791");

	}
}
