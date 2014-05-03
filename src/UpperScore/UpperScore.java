package UpperScore;

import java.util.Scanner;

public class UpperScore {

	public static void main(String[] args) {
		MySQLAccess m = new MySQLAccess();
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println(a);
/*
		boolean exit = false;
		Notes notes = new Notes();
		Belanja belanja = new Belanja();

		while (!exit) {
			System.out.println("Menu");
			System.out.println("1.Notes");
			System.out.println("2.Shop");
			System.out.println("3.Exit");
			System.out.print("Pilih: ");

			Scanner in = new Scanner(System.in);
			int pilihan = in.nextInt();
			if (pilihan == 1) {
				notes.menu();
			} else if (pilihan == 2) {
				belanja.print();
			} else if (pilihan == 3) {
				exit = true;
			}
			in.close();
		}

		BarCode bar = new BarCode();
		BarCode bar2 = new BarCode("208409328402938");
		bar.print();
		bar2.print();

		Vector<String> tag = new Vector<String>();
		tag.add("biskuit");
		tag.add("renyah");
		tag.add("enak");

		Produk produk = new Produk();
		produk.print();
		Produk produk2 = new Produk(bar2, "tango", 5000, tag);
		produk2.print();

		Item item = new Item();
		item.print();
		Item item2 = new Item(bar, "tango", 5000, tag, 200);
		item2.print();

		Notes notes = new Notes();
		notes.print();
		Notes note2 = new Notes(tag, 50000);
		note2.print();

		Supermarket sm = new Supermarket();
		sm.print();
		Supermarket sm2 = new Supermarket("Giant");
		sm2.addProduk(produk);
		sm2.addProduk(produk2);
		sm2.print();

		Belanja belanja = new Belanja();
		belanja.print();
		Belanja belanja2 = new Belanja();
		belanja2.addBelanja(item);
		belanja2.addBelanja(item2);
		belanja2.print();

		MySQLAccess dao = new MySQLAccess();
		try {
			dao.readDataBase();
		} catch (Exception e) {
			System.err.println(e);
		}
*/
	}

}
