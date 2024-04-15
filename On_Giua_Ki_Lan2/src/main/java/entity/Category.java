package entity;

import java.io.Serializable;

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
public class Category implements Serializable {
//	{"description":"Soft drinks, coffees, teas, beers, and ales",│
//	│"categoryName":"Beverages","picture":"0x151C2F00020000000D000│
//	│E0014002100FFFFFFFF4269746D617020496D616","categoryID":"1"}
	private static final long serialVersionUID = -6470090944414208496L;
	@SerializedName("categoryID")
	private String categoryId;
	@SerializedName("categoryName")
	private String categoryName;
	@SerializedName("description")
	private String description;
	private String picture;
}
