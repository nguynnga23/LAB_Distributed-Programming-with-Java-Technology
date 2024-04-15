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
public class Address {
	@Column(name = "street", columnDefinition = "nvarchar(50)", nullable = false)
	private String street;
	@Column(name = "city", columnDefinition = "nvarchar(50)", nullable = false)
	private String city;
	@Column(name = "state", columnDefinition = "nvarchar(50)", nullable = false)
	private String state;
	@Column(name = "zip_code", columnDefinition = "nvarchar(50)", nullable = false)
	private String zipCode;
}
