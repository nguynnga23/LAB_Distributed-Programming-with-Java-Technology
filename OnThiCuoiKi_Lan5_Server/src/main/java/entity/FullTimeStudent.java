package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 21, 2024
 */
@Entity
@Table(name = "full_time_students")
public class FullTimeStudent extends Student implements Serializable {
	private static final long serialVersionUID = 5460490894975552391L;
	private String department;
	private String faculty;

	public FullTimeStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullTimeStudent(String id, String name, String email, LocalDate dob, Set<String> phones, Address address,
			Gender gender) {
		super(id, name, email, dob, phones, address, gender);
		// TODO Auto-generated constructor stub
	}

	public FullTimeStudent(String department, String faculty) {
		super();
		this.department = department;
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "FullTimeStudent [department=" + department + ", faculty=" + faculty + "]";
	}

}
