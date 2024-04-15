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
@Table(name = "categories")
public class Category {
	@Id
	@Column(name = "category_id", nullable = false)
	private int id;
	@Column(name = "category_name", columnDefinition = "nvarchar(50)", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;

}
