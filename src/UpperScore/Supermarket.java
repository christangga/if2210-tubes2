package UpperScore;

import java.util.ArrayList;
import java.util.List;

public class Supermarket {

	// Attributes
	private List<Produk> list;
	private String name;

	// Constructors
	public Supermarket() {
		list = new ArrayList<Produk>();
		name = "";
	}

	public Supermarket(String name) {
		list = new ArrayList<Produk>();
		this.name = new String(name);
	}

	// Getters and Setters
	public List<Produk> getList() {
		return list;
	}

	public String getName() {
		return name;
	}

	public void setList(List<Produk> list) {
		this.list = list;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Methods
	public void addProduk(Produk P) {
		if (!list.contains(P))
			list.add(P);
	}

	public void delProduk(Produk P) {
		list.remove(P);
	}

	public void delProduk(BarCode B) {
		for (Produk P : list) {
			if (P.getBarCode() == B)
				list.remove(P);
		}
	}

	public boolean isBCAvailable(BarCode B) {
		boolean available = false;
		for (Produk P : list) {
			if (P.getBarCode().equals(B))
				available = true;
		}
		return available;
	}

	public void print() {
		System.out.println("Nama : " + name);
		for (Produk P : list) {
			P.print();
		}
	}

}
