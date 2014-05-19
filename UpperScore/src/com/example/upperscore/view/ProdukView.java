package com.example.upperscore.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.upperscore.R;
import com.example.upperscore.controller.ItemArrayAdapter;
import com.example.upperscore.controller.PreviewArrayAdapter;
import com.example.upperscore.controller.ProdukArrayAdapter;
import com.example.upperscore.model.Barcode;
import com.example.upperscore.model.Belanja;
import com.example.upperscore.model.Produk;
import com.example.upperscore.model.Source;

public class ProdukView extends Activity {
	public int SCANNER_REQUEST_CODE = 1;

	private ListView produkListView;
	private String supermarket_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produkview_listview);

		Bundle extras = getIntent().getExtras();
		supermarket_name = extras.getString("supermarket_name");
		Source.getInstance().setBelanja(new Belanja(supermarket_name));
		setTitle(supermarket_name);

		produkListView = (ListView) findViewById(R.id.produkListView);
		produkListView.setAdapter(new ItemArrayAdapter(getApplicationContext(), R.layout.produkview_listview_item, Source.getInstance().getBelanja().getshoppingList()));
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == SCANNER_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				String scanContent = intent.getStringExtra("SCAN_RESULT");
				String scanFormat = intent.getStringExtra("SCAN_RESULT_FORMAT");
				
				int index = 0;
				for (Produk p : Source.getInstance().getProdukList(supermarket_name)) {
					if (p.getBarcode().getId().equals(scanContent)) {
						break;
					} else {
						++index;
					}
				}
				if (index == Source.getInstance().getProdukList(supermarket_name).size()) {
					Toast toast = Toast.makeText(getApplicationContext(),
							"No Products found in database", Toast.LENGTH_SHORT);
					toast.show();
				} else {
					Source.getInstance().getBelanja().addBelanja(new Barcode(scanContent), 0);
				}
				//System.out.println(Source.getInstance().getBelanja().getLocation(scanContent));
				//System.out.println(Source.getInstance().getBelanja().getshoppingList().get(Source.getInstance().getBelanja().getLocation(scanContent)).getNama());
			} else if (resultCode == Activity.RESULT_CANCELED) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"No scan data received!", Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_item, menu);
		getMenuInflater().inflate(R.menu.menu_browse, menu);
		getMenuInflater().inflate(R.menu.search, menu);
		getMenuInflater().inflate(R.menu.menu_done, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.action_done:
			produkListView.setAdapter(new PreviewArrayAdapter(getApplicationContext(), R.layout.produkview_listview_item, Source.getInstance().getBelanja().getshoppingList()));
			break;
		case R.id.action_search:
			Intent intent = new Intent("com.google.zxing.client.android.SCAN");
			intent.putExtra("SCAN_MODE", "SCAN_MODE");
			startActivityForResult(intent, SCANNER_REQUEST_CODE);
			break;
		case R.id.action_browse:
			produkListView.setAdapter(new ProdukArrayAdapter(getApplicationContext(), R.layout.produkview_listview_item, Source.getInstance().getProdukList(supermarket_name)));
			break;
		case R.id.action_item:
			produkListView.setAdapter(new ItemArrayAdapter(getApplicationContext(), R.layout.produkview_listview_item, Source.getInstance().getBelanja().getshoppingList()));
			break;
		}
		return true;
	}
	
}
