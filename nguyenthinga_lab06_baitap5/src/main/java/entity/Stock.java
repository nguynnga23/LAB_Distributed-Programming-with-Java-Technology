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
@Table(name = "stocks")
public class Stock {
	private int quantity;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
	private Product product;
	
}
