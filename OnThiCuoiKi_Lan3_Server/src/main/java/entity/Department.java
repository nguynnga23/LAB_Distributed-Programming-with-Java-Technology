package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */

@Entity
@Table(name = "Department")
public class Department implements Serializable {

	private static final long serialVersionUID = -3444087970983874973L;
	@Id
	private String id;
	private String name;
	private String location;

	@OneToMany(mappedBy = "department")
	private Set<Treatment> treatments;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String id, String name, String location, Set<Treatment> treatments) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.treatments = treatments;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(Set<Treatment> treatments) {
		this.treatments = treatments;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + ", treatments=" + treatments
				+ "]";
	}

}
