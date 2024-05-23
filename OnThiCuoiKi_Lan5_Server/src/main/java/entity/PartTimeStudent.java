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
@Table(name = "part_time_students")
public class PartTimeStudent extends Student implements Serializable {

	private static final long serialVersionUID = -3617708344694464472L;
	private String supervisor;

	public PartTimeStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartTimeStudent(String id, String name, String email, LocalDate dob, Set<String> phones, Address address,
			Gender gender) {
		super(id, name, email, dob, phones, address, gender);
		// TODO Auto-generated constructor stub
	}

	public PartTimeStudent(String supervisor) {
		super();
		this.supervisor = supervisor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "PartTimeStudent [supervisor=" + supervisor + "]";
	}

}
