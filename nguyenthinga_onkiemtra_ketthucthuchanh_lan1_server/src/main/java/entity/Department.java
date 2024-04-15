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
@Table(name = "Department")
public class Department implements Serializable {
	private static final long serialVersionUID = -3444087970983874973L;
	
	@Id
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private String location;
	
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Treatment> treatments;
}
