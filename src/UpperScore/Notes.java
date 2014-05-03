package UpperScore;

import java.util.Scanner;
import java.util.Vector;

public class Notes {

	// Attributes
	private Vector<String> list;
	private int budget;

	// Constructors
	public Notes() {
		list = new Vector<>();
		budget = 0;
	}

	public Notes(Vector<String> list, int budget) {
		this.list = new Vector<>(list);
		this.budget = budget;
	}

	// Getters and Setters
	public Vector<String> getList() {
		return list;
	}

	public int getBudget() {
		return budget;
	}

	public void setList(Vector<String> list) {
		this.list = list;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	// Methods
	public void addList(String list) {
		this.list.add(list);
	}

	public void delList(String list) {
		this.list.remove(list);
	}

	public void print() {
		System.out.println("-----------------------------");
		System.out.println("Notes");
		System.out.println("List   : " + list);
		System.out.println("Budget : " + budget);
		System.out.println("-----------------------------");

	}

	public void menu() {
		boolean exit = false;
		while (!exit) {
			print();
			System.out.println("1. Set Budget");
			System.out.println("2. Add List");
			System.out.println("3. Delete List");
			System.out.println("4. Back");
			System.out.println("Choose: ");
			Scanner in = new Scanner(System.in);
			int pilihan = in.nextInt();
			if (pilihan == 1) {
				System.out.print("Set Budget: ");
				int budget = in.nextInt();
				setBudget(budget);
			} else if (pilihan == 2) {
				System.out.print("Add List: ");
				String add = in.next();
				if (!list.contains(add)) {
					addList(add);
				}
			} else if (pilihan == 3) {
				System.out.print("Delete List: ");
				String del = in.next();
				if (list.contains(del)) {
					delList(del);
				}
			} else if (pilihan == 4) {
				exit = true;
			}
			in.close();
		}
	}
	
}
