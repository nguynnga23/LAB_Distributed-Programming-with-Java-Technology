package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nguyen Thi Nga
 * @date Apr 13, 2024
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "Doctor")
public class Doctor extends Person implements Serializable {
	private static final long serialVersionUID = -4769011538828160635L;
	
	@Column(nullable = true)
	private String speciality;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	private List<Treatment> treatments;

	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}

	
	

	
	
	
	
}
