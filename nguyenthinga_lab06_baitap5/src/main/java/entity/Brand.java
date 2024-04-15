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
@Table(name = "brands")
public class Brand {
	@Id
	@Column(name = "brand_id", nullable = false)
	private int id;
	@Column(name = "brand_name", columnDefinition = "nvarchar(50)", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "brand")
	private List<Product> products;
	
}
