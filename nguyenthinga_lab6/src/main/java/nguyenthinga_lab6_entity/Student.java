package nguyenthinga_lab6_entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="students")
public class Student {
	@Id
	@Column(name="student_id")
	protected String studentId;
	@Column(columnDefinition="nvarchar(100)", nullable=false)
	protected String name;
	@Column(unique=true, nullable=false)
	
	protected String email;
	protected LocalDate dob;
	protected Set<String> phones;
	protected Address address;
	protected Gender gender;
}
