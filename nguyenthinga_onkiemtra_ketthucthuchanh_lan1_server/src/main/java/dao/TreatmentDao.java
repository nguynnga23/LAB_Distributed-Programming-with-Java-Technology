package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entity.Doctor;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
public interface TreatmentDao extends Remote {
	
//  + getNoTreatmentsByDoctors (int month, int year) : Map<Doctor, Integer> : Thống kê số lượt điều trị bệnh của các bác sĩ theo tháng / năm (dựa vào
//	ngày bắt đầu). Sắp xếp theo chuyên môn của bác sĩ.

	public Map<Doctor, Long> getNoTreatmentsByDoctors(int month, int year) throws RemoteException;

//	+ getDoctorsByDepartment(deptName: String): Map<Doctor, String> : Tìm kiếm danh sách các bác sỹ đã từng điều trị cho bệnh nhân ở một khoa
//  nào đó khi biết tên khoa. TRẢ VỀ MAP<DOCTOR, STRING>

	public Map<Doctor, String> getDoctorsByDepartmentReturnMap(String deptName) throws RemoteException;

//	+ getDoctorsByDepartment(deptName: String): List<Doctor> : Tìm kiếm danh sách các bác sỹ đã từng điều trị cho bệnh nhân ở một khoa
//  nào đó khi biết tên khoa. TRẢ VỀ LIST DOCTOR
	public List<Doctor> getDoctorsByDepartmentReturnList(String deptName) throws RemoteException;
}
