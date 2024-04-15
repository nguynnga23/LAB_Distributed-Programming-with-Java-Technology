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

public class Supplier {
//	{"country":"UK","contactTitle":"Purchasing Manager","address":"49 Gilb│
//		│ert St.","supplierID":"1","phone":"(171) 555-2222","city":"London","co│
//		│ntactName":"Charlotte Cooper","companyName":"Exotic Liquids","postalCo│
//		│de":"EC1 4SD","region":"NULL","fax":"NULL","homePage":"NULL"} 
	@SerializedName("supplierID")
	private String supplierId;
	private transient Address address;
	private transient Contact contact;
	private String companyName;
}
