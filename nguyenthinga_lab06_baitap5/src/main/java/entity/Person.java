package entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 27, 2024
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

//@Entity
//@Table(name = "persons")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Person {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	protected String id;
	@Column(name = "first_name", columnDefinition = "nvarchar(50)", nullable = false)
	protected String firstName;
	@Column(name = "last_name", columnDefinition = "nvarchar(50)", nullable = false)
	protected String lastName;
	
	@Embedded
	protected Contact contact;

}
