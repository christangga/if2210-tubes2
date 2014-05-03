package UpperScore;

import java.util.Vector;

public class Produk {

	// Attributes
	private BarCode barCode;
	private String nama;
	private int harga;
	private Vector<String> tag;

	// Constructors
	public Produk() {
		barCode = new BarCode();
		nama = "";
		harga = 0;
		tag = new Vector<String>();
	}

	public Produk(BarCode barCode, String nama, int harga, Vector<String> tag) {
		this.barCode = new BarCode(barCode.getId());
		this.nama = nama;
		this.harga = harga;
		this.tag = new Vector<String>(tag);
	}

	// Getters and Setters
	public BarCode getBarCode() {
		return barCode;
	}

	public String getNama() {
		return nama;
	}

	public int getHarga() {
		return harga;
	}

	public Vector<String> getTag() {
		return tag;
	}

	public void setBarCode(BarCode barCode) {
		barCode.setId(barCode.getId());
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public void setTag(Vector<String> tag) {
		this.tag = tag;
	}

	// Methods
	public void print() {
		System.out.println("============================");
		System.out.print("BarCode  : ");
		barCode.print();
		System.out.println("Nama     : " + nama);
		System.out.println("Harga    : " + harga);
		System.out.println("Tag      : " + tag);
	}

}
