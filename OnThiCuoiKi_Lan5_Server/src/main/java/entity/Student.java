package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 21, 2024
 */
@Entity
@Table(name = "students")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Student implements Serializable {
	private static final long serialVersionUID = 1779907262484963234L;
	@Id
	@Column(name = "student_id")
	protected String id;
	protected String name;
	protected String email;
	protected LocalDate dob;

	@ElementCollection
	@CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "phone", nullable = false)
	protected Set<String> phones;

	@Embedded
	protected Address address;

	@Enumerated(EnumType.STRING)
	protected Gender gender;

	@OneToMany(mappedBy = "student")
	protected Set<Enrollment> enrollments;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	protected Clazz clazz;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	protected Student student;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, String email, LocalDate dob, Set<String> phones, Address address,
			Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phones = phones;
		this.address = address;
		this.gender = gender;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phones=" + phones
				+ ", address=" + address + ", gender=" + gender + "]";
	}

}
