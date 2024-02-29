package entity;

/**
 * @author Nguyen Thi Nga
 * @date Feb 25, 2024
 */
public class Category {
	private String id;
	private String name;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
