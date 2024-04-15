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
public class Product {
//	{"reorderLevel":10,"unitsInStock":39,"unitPrice":18.0,"supplierID":"1"│
//		│,"productID":"1","quantityPerUnit":"10 boxes x 20 bags","discontinued"│
//		│:false,"productName":"Chai","unitsOnOrder":0,"categoryID":"1"}  
	@SerializedName("productID")
	private String productId;
	@ToString.Exclude
	private Supplier supplier;
	@ToString.Exclude
	private Category category;
	private int reorderLevel;
	private int unitsInStock;
	private float unitPrice;
	private String quantityPerUnit;
	private Boolean discoutinued;
	@SerializedName("productName")
	private String productName;
	private int unitsOnOrder;
	public Product(String productId, int reorderLevel, int unitsInStock, float unitPrice, String quantityPerUnit,
			Boolean discoutinued, String productName, int unitsOnOrder) {
		super();
		this.productId = productId;
		this.reorderLevel = reorderLevel;
		this.unitsInStock = unitsInStock;
		this.unitPrice = unitPrice;
		this.quantityPerUnit = quantityPerUnit;
		this.discoutinued = discoutinued;
		this.productName = productName;
		this.unitsOnOrder = unitsOnOrder;
	}
	
	

	
}
