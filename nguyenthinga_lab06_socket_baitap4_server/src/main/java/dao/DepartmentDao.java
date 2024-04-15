package dao;

import java.util.List;
import java.util.Map;

import entity.Department;
import jakarta.persistence.EntityManager;

/**
 * @author Nguyen Thi Nga
 * @date Apr 1, 2024
 */
public interface DepartmentDao {
	
	public void close();

	public boolean addDepartment(Department department);

	public boolean updateDepartment(Department department);

	public boolean deleteDepartment(int id);

	public List<Department> findAll();

	public Department findById(int id);

	public List<Department> findByName(String name);

	/**
	 * @return
	 */
	public Map<Department, Long> countCoursesByDepartment();

	/**
	 * @param department
	 * @return
	 */

}
