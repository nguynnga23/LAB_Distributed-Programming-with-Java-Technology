package dao;

import java.util.List;
import java.util.Map;

import entity.Doctor;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
public interface DoctorDao {
	public List<Doctor> getDoctorsByDepartment(String deptName);
	public Map<Doctor, Long> getNoTreatmentsByDoctors(int month, int year);
}





























