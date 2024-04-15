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
@Embeddable
public class Contact {
	@Column(name = "phone", columnDefinition = "nvarchar(50)", nullable = false)
	private String phone;
	@Column(name = "email", columnDefinition = "nvarchar(50)", nullable = false)
	private String email;
}
