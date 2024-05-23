package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */
@Entity
@Table(name = "positions")
@NamedNativeQueries({
	@NamedNativeQuery(name = "Position.listPositionsByNameAndSalary", query = "SELECT * FROM positions p "
			+ "WHERE p.name LIKE ? "
			+ "      AND p.salary >= ? "
			+ "      AND p.salary <= ? "
			+ "ORDER BY p.name", resultClass = Position.class),
	@NamedNativeQuery(name = "Position.listYearsOfExperienceByPosition", query = "SELECT e.position_id, DATEDIFF(YEAR, e.from_date, e.to_date) AS duration "
			+ "FROM experiences e "
			+ "WHERE e.candidate_id = ?")
})
public class Position implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2445301921599620461L;
	@Id
	@Column(name = "position_id")
	private String id;
	private String name;
	private String description;
	private double salary;
	private int number;

	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
	private Set<Candidate> candidates;

	@OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
	private Set<Experience> experiences;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(String id, String name, String description, double salary, int number) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.salary = salary;
		this.number = number;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", description=" + description + ", salary=" + salary
				+ ", number=" + number + "]";
	}

}
