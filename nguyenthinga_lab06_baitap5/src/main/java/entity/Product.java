package entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Nguyen Thi Nga
 * @date Mar 27, 2024
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "product_id", nullable = false)
	private int id;
	@Column(name = "product_name", columnDefinition = "nvarchar(50)", nullable = false)
	private String name;
	@Column(name = "model_year", nullable = false)
	private int modelYear;
	@Column(name = "list_price", nullable = false)
	private double listPrice;
	
	@OneToMany(mappedBy = "product")
	private List<OrderItem> orderItems;
	
	@OneToMany(mappedBy = "product")
	private List<Stock> stocks;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	
}
