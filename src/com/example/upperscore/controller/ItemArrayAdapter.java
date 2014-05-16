package com.example.upperscore.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

import com.example.upperscore.R;
import com.example.upperscore.model.Item;
import com.example.upperscore.model.Source;

public class ItemArrayAdapter extends ArrayAdapter<Item> {

	private final List<Item> values;

	public ItemArrayAdapter(Context context, int resource, List<Item> values) {
		super(context, resource, values);
		this.values = values;
	}

	@Override
	public int getCount() {
		if (values == null) {
			return 0;
		} else {
			return values.size();
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(getContext());
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.itemview_listview_item, parent, false);
		}
		
		ImageView imageView = (ImageView) convertView.findViewById(R.id.itemListViewItemImageView);
		TextView textViewName = (TextView) convertView.findViewById(R.id.itemListViewItemTextViewName);
		TextView textViewPrice = (TextView) convertView.findViewById(R.id.itemListViewItemTextViewPrice);
		NumberPicker numberPicker = (NumberPicker) convertView.findViewById(R.id.itemListViewItemNumberPicker);
	
		final Item item = values.get(position);
		imageView.setImageResource(R.drawable.icon_green);
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// pop up dialog
			}
		});
		
		textViewName.setText(item.getNama());
		
		DecimalFormat currId = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols rupiahFormat = new DecimalFormatSymbols();

        rupiahFormat.setCurrencySymbol("Rp.");
        rupiahFormat.setMonetaryDecimalSeparator(',');
        rupiahFormat.setGroupingSeparator('.');

        currId.setDecimalFormatSymbols(rupiahFormat);

		textViewPrice.setText(String.valueOf(currId.format(item.getHarga())));
		numberPicker.setMinValue(0);
		numberPicker.setMaxValue(100);
		int index = Source.getInstance().getBelanja().getLocation(item.getBarcode().getId());
		numberPicker.setValue(Source.getInstance().getBelanja().getshoppingList().get(index).getQuantity());
		numberPicker.setWrapSelectorWheel(false);
		numberPicker.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				picker.setValue(newVal);
				Source.getInstance().getBelanja().addBelanja(item.getBarcode(), newVal-oldVal);
			}
		});
		
		return convertView;
	}

}
