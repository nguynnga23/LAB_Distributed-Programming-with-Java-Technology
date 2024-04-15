package nguyenthinga_lab6_entity;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name="classes_profiles")
public class ClazzProfile {
	@Id
	@OneToOne
	@JoinColumn(name="class_id")
	private Class clazz;
	private LocalDate createDate;
	private String description;
}
