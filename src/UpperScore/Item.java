package UpperScore;

import java.util.Vector;

public class Item extends Produk {

	// Attributes
	private int quantity;

	// Constructors
	public Item() {
		super();
		quantity = 0;
	}

	public Item(BarCode barCode, String nama, int harga, Vector<String> tag,
			int quantity) {
		super(barCode, nama, harga, tag);
		this.quantity = quantity;
	}

	// Getters and Setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Methods
	public void print() {
		super.print();
		System.out.println("Quantity : " + quantity);
	}

}
