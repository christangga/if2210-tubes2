package UpperScore;

public class BarCode {
	
	// Attributes
	private String id;

	// Constructors
	public BarCode() {
		id = null;
	}

	public BarCode(String id) {
		this.id = id;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// Methods
	public void print() {
		System.out.println(id);
	}
	
}
