package entity;

public class Category {
//	{"description":"Soft drinks, coffees, teas, beers, and ales",│
//	│"categoryName":"Beverages","picture":"0x151C2F00020000000D000│
//	│E0014002100FFFFFFFF4269746D617020496D616","categoryID":"1"}
	private String categoryId;
	private String categoryName;
	private String description;
	private String picture;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryId, String categoryName, String description, String picture) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description=" + description
				+ ", picture=" + picture + "]";
	}

}
