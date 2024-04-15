package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import lombok.ToString.Exclude;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "Treatment")
public class Treatment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2703009892295683150L;
	private LocalDate startDate;
	@Column(nullable = true)
	private LocalDate endDate;
	private String diagnosis;

	@Exclude
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@Id
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Id
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@Override
	public String toString() {
		return "Treatment [startDate=" + startDate + ", endDate=" + endDate + ", diagnosis=" + diagnosis + ", doctor="
				+ doctor.getId() + ", patient=" + patient.getId() + ", department=" + department.getId() + "]";
	}
}
