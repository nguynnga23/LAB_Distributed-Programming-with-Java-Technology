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
//@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "customers")
//@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends Person {
	@Embedded
	private Address address;
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
}
