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
@Table(name = "courses")
public class Course implements Serializable {
	private static final long serialVersionUID = 7643170416233054127L;
	@Id
	@Column(name = "course_id")
	private String id;
	private String name;
	private int credits;
	
	@OneToMany(mappedBy = "course")
	private Set<Enrollment> enrollments;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String id, String name, int credits) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credits=" + credits + "]";
	}

}
