package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
@Entity
@Table(name = "beverages")
public class Beverage extends Item {

	@Column(name = "supplier_name")
	private String supplierName;

	@Enumerated(EnumType.STRING)
	private Size size;

	public Beverage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beverage(String id, String name, double price, String description, boolean onSpecial) {
		super(id, name, price, description, onSpecial);
		// TODO Auto-generated constructor stub
	}

	public Beverage(String supplierName, Size size) {
		super();
		this.supplierName = supplierName;
		this.size = size;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Beverage [supplierName=" + supplierName + ", size=" + size + ", id=" + id + ", name=" + name
				+ ", price=" + price + ", description=" + description + ", onSpecial=" + onSpecial + ", ingredients="
				+ ingredients + "]";
	}

	

}
