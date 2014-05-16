package com.example.upperscore.controller;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.upperscore.model.Supermarket;

public class HomeArrayAdapter extends ArrayAdapter<Supermarket> {

	private final Context context;
	private final List<Supermarket> values;

	public HomeArrayAdapter(Context context, int resource,
			int textViewResourceId, List<Supermarket> values) {
		super(context, resource, textViewResourceId, values);
		this.context = context;
		this.values = values;
	}

}
