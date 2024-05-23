package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

/**
 * @author Nguyen Thi Nga
 * @date May 22, 2024
 */
@Entity
@DiscriminatorValue("admin_name")
public class Admin extends User implements Serializable {
	private static final long serialVersionUID = 7249946877130664106L;
	@OneToMany(mappedBy = "admin")
	private Set<Post> posts;
	

}
