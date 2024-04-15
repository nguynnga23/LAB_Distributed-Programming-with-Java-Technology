package entity;

public class Product {
//	{"reorderLevel":10,"unitsInStock":39,"unitPrice":18.0,"supplierID":"1"│
//		│,"productID":"1","quantityPerUnit":"10 boxes x 20 bags","discontinued"│
//		│:false,"productName":"Chai","unitsOnOrder":0,"categoryID":"1"}  
	private String productId;
	private Supplier supplier;
	private Category category;
	private int reorderLevel;
	private int unitsInStock;
	private float unitPrice;
	private String quantityPerUnit;
	private Boolean discoutinued;
	private String productName;
	private int unitsOnOrder;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, Supplier supplier, Category category, int reorderLevel, int unitsInStock,
			float unitPrice, String quantityPerUnit, Boolean discoutinued, String productName, int unitsOnOrder) {
		super();
		this.productId = productId;
		this.supplier = supplier;
		this.category = category;
		this.reorderLevel = reorderLevel;
		this.unitsInStock = unitsInStock;
		this.unitPrice = unitPrice;
		this.quantityPerUnit = quantityPerUnit;
		this.discoutinued = discoutinued;
		this.productName = productName;
		this.unitsOnOrder = unitsOnOrder;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public Boolean getDiscoutinued() {
		return discoutinued;
	}

	public void setDiscoutinued(Boolean discoutinued) {
		this.discoutinued = discoutinued;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", supplier=" + supplier + ", category=" + category
				+ ", reorderLevel=" + reorderLevel + ", unitsInStock=" + unitsInStock + ", unitPrice=" + unitPrice
				+ ", quantityPerUnit=" + quantityPerUnit + ", discoutinued=" + discoutinued + ", productName="
				+ productName + ", unitsOnOrder=" + unitsOnOrder + "]";
	}

}
