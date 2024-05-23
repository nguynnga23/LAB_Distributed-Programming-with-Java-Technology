package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
@Entity
@Table(name = "Doctor")
public class Doctor extends Person implements Serializable {
	private static final long serialVersionUID = -1809319131498697128L;
	private String speciality;

	@OneToMany(mappedBy = "doctor")
	private Set<Treatment> treatments;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String id, String name, String phone) {
		super(id, name, phone);
		// TODO Auto-generated constructor stub
	}

	public Doctor(String speciality) {
		super();
		this.speciality = speciality;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + "]";
	}

}
