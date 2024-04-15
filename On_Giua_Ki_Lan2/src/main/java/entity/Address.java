package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * @author Nguyen Thi Nga
 * @date Mar 20, 2024
 */
public class Address {
	private String address;
	private String city;
	private String region;
	private String postalCode;
	private String country;
}
