package com.example.upperscore.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class Source {

	private static Source instance = new Source();
	private List<Supermarket> supermarketList = new ArrayList<Supermarket>();
	private Belanja belanja = new Belanja();
	private Context context;
	
	private Source() {
	}

	// Get the only object available
	public static Source getInstance() {
		return instance;
	}

	public List<Supermarket> getSupermarketList() {
		return supermarketList;
	}

	public Belanja getBelanja() {
		return belanja;
	}

	public void setSupermarketList(List<Supermarket> supermarketList) {
		this.supermarketList = supermarketList;
	}

	public void setBelanja(Belanja belanja) {
		this.belanja = belanja;
	}

	public List<Produk> getProdukList(String supermarket_name) {
		for (Supermarket s:supermarketList) {
			if (s.getName().equals(supermarket_name)) {
				return s.getList();
			}
		}
		return null;
	}

	public Context getContext() {
		return context;
	}
	
	public void setContext(Context context) {
		this.context = context;
	}
}
