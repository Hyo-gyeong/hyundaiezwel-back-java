package sec06;

public class ProductVO {
	private String id;
	private String category;
	private String name;
	private int price;
	
	public ProductVO() {
	}

	public ProductVO(String id, String category, String name, int price) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
