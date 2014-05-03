package UpperScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Belanja {
	
	// Attributes
	private List<Item> shoppingList;

	// Constructors
	public Belanja() {
		shoppingList = new ArrayList<Item>();
	}

	public Belanja(List<Item> L) {
		shoppingList = new ArrayList<Item>(L);
	}

	// Getters and Setters
	public List<Item> getshoppingList() {
		return shoppingList;
	}

	public void setshoppingList(List<Item> shoppingList) {
		this.shoppingList = shoppingList;
	}

	// Methods
	public void addBelanja(Item item) {
		shoppingList.add(item);
	}

	public void delBelanja(Item item) {
		shoppingList.remove(item);
	}

	public void print() {
		System.out.println("---------------------");
		if (shoppingList.size() > 0) {
			System.out.println("Shopping List :");
			for (Item item : shoppingList) {
				item.print();
			}
		} else {
			System.out.println("Shopping List : -");
		}
		System.out.println("---------------------");
	}

	public void menuBelanja() {
		boolean exit = false;
		while (!exit) {
			print();
			System.out.println("1. Add Shopping List");
			System.out.println("2. Delete Shopping List");
			System.out.println("3. Back");
			System.out.println("Choose: ");
			Scanner in = new Scanner(System.in);
			int pilihan = in.nextInt();
			if (pilihan == 1) {
				System.out.print("Add Barcode: ");
				String add = in.next();
			} else if (pilihan == 2) {
				System.out.print("Delete Barcode: ");
				String del = in.next();
			} else if (pilihan == 3) {
				exit = true;
			}
			in.close();
		}
	}

}