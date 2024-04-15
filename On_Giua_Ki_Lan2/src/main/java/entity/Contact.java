package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Nguyen Thi Nga
 * @date Mar 20, 2024
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
	private String phone;
	private String contactTitle;
	private String contactName;
	private String fax;
	
}
