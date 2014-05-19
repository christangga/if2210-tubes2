package com.example.upperscore.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.upperscore.R;

public class PreviewView extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.produkview_listview);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

}
