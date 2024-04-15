package dao;

import java.util.List;

import entity.Instructor;

/**
 * @author Nguyen Thi Nga
 * @date Apr 3, 2024
 */
public interface IntructorDao {
	public boolean addInstructor(Instructor instructor);

	public boolean updateInstructor(Instructor instructor);

	public boolean deleteInstructor(int id);

	public List<Instructor> findAll();

	public Instructor findById(int id);

	public List<Instructor> findByName(String name);

}
