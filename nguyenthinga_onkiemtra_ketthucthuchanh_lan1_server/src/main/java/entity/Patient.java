package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "Patient")
public class Patient extends Person implements Serializable {
	private static final long serialVersionUID = -3598057298376324671L;
	@Column(nullable = true)
	private String gender;
	@Column(nullable = true)
	private LocalDate dateOfBirth;
	@Column(nullable = true)
	private String address;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	private List<Treatment> treatments;

	public Patient(String id, String name, String phone,String gender, String address, LocalDate dateOfBirth) {
		super(id, name, phone);
		this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
	
	
	
}
