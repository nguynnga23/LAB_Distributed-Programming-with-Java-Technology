package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 21, 2024
 */
@Entity
@Table(name = "classes")
public class Clazz implements Serializable {
	private static final long serialVersionUID = -4107602076997508801L;
	@Id
	@Column(name = "class_id")
	private String id;
	private String name;
	private int noOfStudents;

	@OneToMany(mappedBy = "clazz")
	private Set<Student> students;

	public Clazz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clazz(String id, String name, int noOfStudents, Set<Student> students, ClazzProfile clazzProfile) {
		super();
		this.id = id;
		this.name = name;
		this.noOfStudents = noOfStudents;
		this.students = students;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", noOfStudents=" + noOfStudents + ", students=" + students + "]";
	}

}
