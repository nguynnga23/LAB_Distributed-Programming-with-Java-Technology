package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import dao.TreatmentDao;
import entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
public class TreatmentImpl extends UnicastRemoteObject implements TreatmentDao {

	private static final long serialVersionUID = 3971346922502211414L;
	private EntityManager em;

	public TreatmentImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("JPA_ORM_MSSQL").createEntityManager();
	}

	@Override
	// CÂU TRUY VẤN CÓ SẮP XẾP THEO ..(ORDER BY) thì phải sử dụng
	// LinkedHashMap/LinkedHashSet để giữ nguyên thứ tự
	// CÂU TRUY VẤN KHÔNG CÓ SẮP XẾP THÌ CÓ THỂ SỬ DỤNG HashMap/HashSet
	
	public Map<Doctor, Long> getNoTreatmentsByDoctors(int month, int year) throws RemoteException {
		Map<Doctor, Long> result = new LinkedHashMap<>();
		List<?> list = em.createQuery(
				"SELECT t.doctor, COUNT(t) FROM Treatment t WHERE MONTH(t.startDate) = :month AND YEAR(t.startDate) = :year GROUP BY t.doctor ORDER BY COUNT(t)",
				Object[].class).setParameter("month", month).setParameter("year", year).getResultList();
		list.stream().map(o -> (Object[]) o).forEach(a -> {
			Doctor doctor = (Doctor) a[0];
			Long count = (Long) a[1];
			result.put(doctor, count);
		});
		return result;
	}

	
	@Override
	public Map<Doctor, String> getDoctorsByDepartmentReturnMap(String deptName) throws RemoteException {
		// SỬ DỤNG TREE MAP ĐỂ SẮP XẾP THEO ID CỦA DOCTOR HOẶC MỘT TRƯỜNG DỮ LIỆU KHÁC
		Map<Doctor, String> result = new TreeMap<Doctor, String>(Comparator.comparing(Doctor::getId));

		List<?> list = em
				.createQuery("SELECT t.doctor, t.department.name FROM Treatment t WHERE t.department.name = :deptName",
						Object[].class)
				.setParameter("deptName", deptName).getResultList();
		list.stream().map(o -> (Object[]) o).forEach(a -> {
			Doctor id = (Doctor) a[0];
			String name = (String) a[1];
			result.put(id, name);
		});
		return result;
	}

	@Override
	public List<Doctor> getDoctorsByDepartmentReturnList(String deptName) throws RemoteException {
		return em.createQuery("SELECT t.doctor FROM Treatment t WHERE t.department.name = :deptName", Doctor.class)
				.setParameter("deptName", deptName).getResultList();
	}

	public static void main(String[] args) {
		try {
			TreatmentDao treatmentDao = new TreatmentImpl();
			Set<Entry<Doctor, String>> map = treatmentDao.getDoctorsByDepartmentReturnMap("Dermatology").entrySet();
			map.forEach(System.out::println);
			System.out.println("-----------------------------------------------------------------------------------");
			List<Doctor> list = treatmentDao.getDoctorsByDepartmentReturnList("Dermatology");
			list.forEach(System.out::println);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
