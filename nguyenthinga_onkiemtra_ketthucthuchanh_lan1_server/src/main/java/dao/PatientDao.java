package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Patient;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
public interface PatientDao extends Remote {
	
//	+ addPatient (patient: Patient) : boolean - Thêm mới một bệnh nhân vào cơ sở dữ liệu
	public boolean addPatient(Patient patient) throws RemoteException;
}
