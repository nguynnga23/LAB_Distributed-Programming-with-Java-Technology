package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
@Entity
@Table(name = "classes_profiles")
public class ClazzProfile implements Serializable {
	private static final long serialVersionUID = 7835001157699843258L;
	@Id
	@Column(name = "profile_id")
	private String id;
	private String description;
	private LocalDate createDate;

	@OneToOne
	@JoinColumn(name = "class_id")
	private Clazz clazz;

	public ClazzProfile() {
		super();
	}

	public ClazzProfile(String id, String description, LocalDate createDate, Clazz clazz) {
		super();
		this.id = id;
		this.description = description;
		this.createDate = createDate;
		this.clazz = clazz;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "ClazzProfile [id=" + id + ", description=" + description + ", createDate=" + createDate + ", clazz="
				+ clazz + "]";
	}

}
