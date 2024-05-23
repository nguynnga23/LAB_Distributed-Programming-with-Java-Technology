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
@Table(name = "foods")
public class Food extends Item {
	@Enumerated(EnumType.STRING)
	private Type type;
	@Column(name = "preparation_time")
	private int preparationTime;
	@Column(name = "serving_time")
	private int servingTime;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String id, String name, double price, String description, boolean onSpecial) {
		super(id, name, price, description, onSpecial);
		// TODO Auto-generated constructor stub
	}

//	public Food(Type type, int preparationTime, int servingTime) {
//		super();
//		this.type = type;
//		this.preparationTime = preparationTime;
//		this.servingTime = servingTime;
//	}

	public Food(String id, String name, double price, String description, boolean onSpecial, Type type,
			int preparationTime, int servingTime) {
		super(id, name, price, description, onSpecial);
		this.type = type;
		this.preparationTime = preparationTime;
		this.servingTime = servingTime;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	public int getServingTime() {
		return servingTime;
	}

	public void setServingTime(int servingTime) {
		this.servingTime = servingTime;
	}

	@Override
	public String toString() {
		return "Food [type=" + type + ", preparationTime=" + preparationTime + ", servingTime=" + servingTime + ", id="
				+ id + ", name=" + name + ", price=" + price + ", description=" + description + ", onSpecial="
				+ onSpecial + "]";
	}

}
