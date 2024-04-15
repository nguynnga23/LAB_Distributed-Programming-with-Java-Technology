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
@Table(name = "stores")
public class Store {
	@Id
	@Column(name = "store_id", nullable = false)
	private int id;
	@Column(name = "store_name", columnDefinition = "nvarchar(50)", nullable = false)
	private String name;
	
	@Embedded
	private Contact contact;
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "store")
	private List<Staff> staffs;
	
	@OneToMany(mappedBy = "store")
	private List<Stock> stocks;
	

}
