package entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
@Entity
@Table(name = "ingredients")
public class Ingredient {
	@Id
	@Column(name = "ingredient_id")
	private String id;
	@Column(name = "ingredient_name")
	private String name;
	private String unit;
	private double price;
	private double quantity;

	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;
	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "supplier_name")
	private String supplierName;

	@ManyToMany
	@JoinTable(name = "items_ingredients", joinColumns = @JoinColumn(name = "ingredient_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
	private Set<Item> items;

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingredient(String id, String name, String unit, double price, double quantity, LocalDate manufacturingDate,
			String supplierName) {
		super();
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.quantity = quantity;
		this.manufacturingDate = manufacturingDate;
		this.supplierName = supplierName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", unit=" + unit + ", price=" + price + ", quantity="
				+ quantity + ", manufacturingDate=" + manufacturingDate + ", supplierName=" + supplierName + "]";
	}

}
