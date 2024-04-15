package entity;

import com.google.gson.annotations.SerializedName;

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
public class Customer {
//	{"country":"Germany","contactTitle":"Sales Representative","address":"│
//		│Obere Str. 57","phone":"030-0074321","city":"Berlin","contactName":"Ma│
//		│ria Anders","companyName":"Alfreds Futterkiste","postalCode":"12209","│
//		│customerID":"ALFKI","fax":"030-0076545","region":"NULL"}   
	@SerializedName("customerID")
	private String customerId;
	private transient Address address;
	private transient Contact contact;
	private String companyName;

}
