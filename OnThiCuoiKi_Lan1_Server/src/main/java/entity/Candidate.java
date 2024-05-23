package entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 3, 2024
 */

@Entity
@Table(name = "candidates")
//select d.id, count(c) as n from Department d join d.courses c group by d.id order by n
//SELECT c.id,COUNT(e) as n FROM Candidate c JOIN c.experiences e GROUP BY c.id ORDER BY n
@NamedNativeQueries({
		@NamedNativeQuery(name = "Cadidate.listCadidatesByCompanies", query = "SELECT c.candidate_id, COUNT(e.company_name) AS n "
				+ "FROM experiences e " + "JOIN candidates c ON e.candidate_id = c.candidate_id "
				+ "GROUP BY c.candidate_id " + "ORDER BY n"),
		@NamedNativeQuery(name = "Cadidate.listCandidatesWithLongestWorking", query = "WITH WorkDurations AS( "
				+ "SELECT *, DATEDIFF(YEAR, e.from_date, e.to_date) AS duration "
				+ "FROM experiences e), MaxDurations AS( " + "SELECT MAX(wd.duration) AS max_duration "
				+ "FROM WorkDurations wd) " + "SELECT wd.candidate_id, wd.position_id, md.max_duration "
				+ "FROM WorkDurations wd, MaxDurations md " + "WHERE wd.duration = md.max_duration"),
		@NamedNativeQuery(name = "Cadidate.listCandidatesAndCertificates", query = "SELECT c.candidate_id, ct.certificate_id "
				+ "FROM candidates c" + "LEFT JOIN certificates ct ON c.candidate_id = ct.candidate_id ") })
public class Candidate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1898695094751569793L;
	@Id
	@Column(name = "candidate_id")
	private String id;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	@Column(name = "gender")
	private String gender;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	private Position position;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	private Set<Experience> experiences;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	private Set<Certificate> certificates;

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String id, String fullName, int yearOfBirth, String gender, String email, String phone,
			String description) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, email, fullName, gender, id, phone, yearOfBirth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(description, other.description) && Objects.equals(email, other.email)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id) && Objects.equals(phone, other.phone)
				&& yearOfBirth == other.yearOfBirth;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", description=" + description + "]";
	}

}
