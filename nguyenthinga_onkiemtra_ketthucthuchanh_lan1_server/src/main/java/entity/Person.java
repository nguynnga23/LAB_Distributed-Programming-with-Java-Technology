package entity;

import java.io.Serializable;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {
	private static final long serialVersionUID = -7728476306071161711L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected String id;
	@Column(name = "name", nullable = false)
	protected String name;
	@Column(name = "phone", nullable = true)
	protected String phone;
}
