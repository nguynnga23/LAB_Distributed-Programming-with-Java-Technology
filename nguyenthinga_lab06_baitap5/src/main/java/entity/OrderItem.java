package entity;

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
@Table(name = "order_items")
public class OrderItem {
	@Column(name = "quantity", nullable = false)
	private int quantity;
	@Column(name = "list_price", nullable = false)
	private double listPrice;
	@Column(name = "discount", nullable = false)
	private double discount;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
}
