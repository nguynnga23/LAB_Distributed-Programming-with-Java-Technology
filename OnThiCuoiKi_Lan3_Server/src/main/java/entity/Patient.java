package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
@Entity
@Table(name = "Patient")
public class Patient extends Person implements Serializable {

	private static final long serialVersionUID = -5646582689804771450L;
	private String gender;
	private LocalDate dateOfBirth;
	private String address;

	@OneToMany(mappedBy = "patient")
	private Set<Treatment> treatments;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String id, String name, String phone) {
		super(id, name, phone);
		// TODO Auto-generated constructor stub
	}

	public Patient(String gender, LocalDate dateOfBirth, String address) {
		super();
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Patient [gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", address=" + address + "]";
	}

}
