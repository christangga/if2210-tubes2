package com.example.upperscore.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.upperscore.R;
import com.example.upperscore.controller.HomeArrayAdapter;
import com.example.upperscore.model.Source;
import com.example.upperscore.model.database.DatabaseHandler;
import com.example.upperscore.test.Test;

public class HomeView extends Activity {

	private ListView homeListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homeview_listview);

		Test.ProdukTest(getApplicationContext());
		Test.ProdukSupermarketTest(getApplicationContext());
		Test.ProdukTagTest(getApplicationContext());
		Test.SupermarketTest(getApplicationContext());
		
		DatabaseHandler handler = new DatabaseHandler(getApplicationContext());
		Source.getInstance().setSupermarketList(handler.getAllSupermarket());
		Source.getInstance().setContext(getApplicationContext());
		handler.close();
		homeListView = (ListView) findViewById(R.id.homeListView);
		homeListView.setAdapter(new HomeArrayAdapter(getApplicationContext(), R.layout.homeview_listview_item, R.id.homeListViewItem, Source.getInstance().getSupermarketList()));
		homeListView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent(getApplicationContext(), ProdukView.class);
				i.putExtra("supermarket_name", parent.getItemAtPosition(position).toString());
				startActivity(i);
			}
		
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_new, menu);
		return true;
	}

}
