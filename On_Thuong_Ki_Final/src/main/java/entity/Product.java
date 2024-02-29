package entity;

import java.util.List;

/**
 * @author Nguyen Thi Nga
 * @date Feb 25, 2024
 */
public class Product {
	private int sku;
	private String name;
	private String type;
	private float price;
	private String upc;
	private List<Category> category;
	private float shipping;
	private String description;
	private String manufacturer;
	private String model;
	private String url;
	private String image;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int sku, String name, String type, float price, String upc, List<Category> category, float shipping,
			String description, String manufacturer, String model, String url, String image) {
		super();
		this.sku = sku;
		this.name = name;
		this.type = type;
		this.price = price;
		this.upc = upc;
		this.category = category;
		this.shipping = shipping;
		this.description = description;
		this.manufacturer = manufacturer;
		this.model = model;
		this.url = url;
		this.image = image;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public float getShipping() {
		return shipping;
	}

	public void setShipping(float shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", name=" + name + ", type=" + type + ", price=" + price + ", upc=" + upc
				+ ", category=" + category + ", shipping=" + shipping + ", description=" + description
				+ ", manufacturer=" + manufacturer + ", model=" + model + ", url=" + url + ", image=" + image + "]";
	}

}
