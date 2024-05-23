package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.bytecode.enhance.spi.EnhancementInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * @author Nguyen Thi Nga
 * @date May 19, 2024
 */
@Entity
@Table(name = "items")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Item implements Serializable {
	private static final long serialVersionUID = 5225724500839829115L;
	@Id
	protected String id;
	protected String name;
	protected double price;
	protected String description;
	@Column(name = "on_special")
	protected boolean onSpecial;

	@ManyToMany(mappedBy = "items")
	protected Set<Ingredient> ingredients;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String id, String name, double price, String description, boolean onSpecial) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.onSpecial = onSpecial;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOnSpecial() {
		return onSpecial;
	}

	public void setOnSpecial(boolean onSpecial) {
		this.onSpecial = onSpecial;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", onSpecial=" + onSpecial + "]";
	}
}
