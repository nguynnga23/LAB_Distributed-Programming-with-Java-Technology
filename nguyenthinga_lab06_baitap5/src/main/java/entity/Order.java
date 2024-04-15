package entity;

import java.time.LocalDate;
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
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "order_id", nullable = false)
	private int id;
	@Column(name = "order_status", nullable = false)
	private byte orderStatus;
	@Column(name = "order_date", nullable = false)	
	private LocalDate orderDate;
	@Column(name = "required_date", nullable = false)
	private LocalDate requiredDate;
	@Column(name = "shipped_date", nullable = false)
	private LocalDate shippedDate;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
