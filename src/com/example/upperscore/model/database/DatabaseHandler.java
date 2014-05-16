package com.example.upperscore.model.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.upperscore.model.Barcode;
import com.example.upperscore.model.Produk;
import com.example.upperscore.model.Supermarket;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "caers_oop";

	private static final String TABLE_PRODUK = "produk";
	private static final String TABLE_PRODUK_TAG = "produk_tag";
	private static final String TABLE_SUPERMARKET = "supermarket";
	private static final String TABLE_PRODUK_SUPERMARKET = "produk_supermarket";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE_PRODUK = "CREATE TABLE " + TABLE_PRODUK + " ("
				+ "barcode varchar(20), "
				+ "nama_produk varchar(255))";

		String CREATE_TABLE_PRODUK_TAG = "CREATE TABLE " + TABLE_PRODUK_TAG
				+ " (" + "barcode varchar(20), "
				+ "tag varchar(255))";

		String CREATE_TABLE_SUPERMARKET = "CREATE TABLE " + TABLE_SUPERMARKET
				+ " (" + "id varchar(20), "
				+ "nama_supermarket varchar(255))";

		String CREATE_TABLE_PRODUK_SUPERMARKET = "CREATE TABLE "
				+ TABLE_PRODUK_SUPERMARKET + " (" + "id varchar(20), "
				+ "barcode varchar(20), " + "harga int(9))";
		
		db.execSQL(CREATE_TABLE_PRODUK);
		db.execSQL(CREATE_TABLE_PRODUK_TAG);
		db.execSQL(CREATE_TABLE_SUPERMARKET);
		db.execSQL(CREATE_TABLE_PRODUK_SUPERMARKET);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String DROP_TABLE_PRODUK = "DROP TABLE IF EXISTS " + TABLE_PRODUK;
		String DROP_TABLE_PRODUK_TAG = "DROP TABLE IF EXISTS "
				+ TABLE_PRODUK_TAG;
		String DROP_TABLE_SUPERMARKET = "DROP TABLE IF EXISTS "
				+ TABLE_SUPERMARKET;
		String DROP_TABLE_PRODUK_SUPERMARKET = "DROP TABLE IF EXISTS "
				+ TABLE_PRODUK_SUPERMARKET;
		
		db.execSQL(DROP_TABLE_PRODUK);
		db.execSQL(DROP_TABLE_PRODUK_TAG);
		db.execSQL(DROP_TABLE_SUPERMARKET);
		db.execSQL(DROP_TABLE_PRODUK_SUPERMARKET);
		
		onCreate(db);
	}

	public boolean addProduk(String barcode, String nama_produk) {
		SQLiteDatabase db = getWritableDatabase();

		Cursor cursor = db.query(TABLE_PRODUK, null, "barcode = \"" + barcode + "\"", null, null, null, null);
		if (cursor.getCount() > 0) {
			return false;
		}

		ContentValues values = new ContentValues();
		values.put("barcode", barcode);
		values.put("nama_produk", nama_produk);
		long t = db.insertWithOnConflict(TABLE_PRODUK, null, values, db.CONFLICT_IGNORE);
		System.out.println(t + "add Produk : " + barcode + " " + nama_produk);
		
		db.close();
		return true;
	}

	public Produk getProduk(String nama_supermarket, String barcode) {
		SQLiteDatabase db = getReadableDatabase();
		
		Produk produk = new Produk();
		
		Cursor cursor = db.query(TABLE_PRODUK + " NATURAL JOIN " + TABLE_SUPERMARKET + " NATURAL JOIN " + TABLE_PRODUK_SUPERMARKET + " NATURAL JOIN " + TABLE_PRODUK_TAG, null, "nama_supermarket = \"" + nama_supermarket + "\" AND barcode = \"" + barcode + "\"", null, null, null, null);
		cursor.moveToFirst();
		if (!cursor.isAfterLast()) {
			System.out.println(cursor.getColumnCount() + " getProduk " + cursor.getString(cursor.getColumnIndex("nama_produk")));
			List<String> tagList = new ArrayList<String>();
			tagList = Arrays.asList(cursor.getString(cursor.getColumnIndex("tag")).split(" *, *"));
			produk = new Produk(new Barcode(cursor.getString(cursor.getColumnIndex("barcode"))),
					cursor.getString(cursor.getColumnIndex("nama_produk")),
					cursor.getInt(cursor.getColumnIndex("harga")), tagList);
			cursor.moveToNext();
		}
		cursor.close();
		db.close();
		return produk;
	}

	public List<Produk> getAllProduk(String nama_supermarket) {
		SQLiteDatabase db = getReadableDatabase();
		
		List<Produk> produkList = new ArrayList<Produk>();
		
		Cursor cursor = db.query(TABLE_PRODUK + " NATURAL JOIN " + TABLE_SUPERMARKET + " NATURAL JOIN " + TABLE_PRODUK_SUPERMARKET + " NATURAL JOIN " + TABLE_PRODUK_TAG, null, "nama_supermarket = \"" + nama_supermarket + "\"", null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			System.out.println("getAllProduk " + cursor.getString(cursor.getColumnIndex("nama_produk")));
			List<String> tagList = new ArrayList<String>();
			tagList = Arrays.asList(cursor.getString(cursor.getColumnIndex("tag")).split(" *, *"));
			produkList.add(new Produk(new Barcode(cursor.getString(cursor.getColumnIndex("barcode"))),
					cursor.getString(cursor.getColumnIndex("nama_produk")),
					cursor.getInt(cursor.getColumnIndex("harga")), tagList));
			cursor.moveToNext();
		}
		
		cursor.close();
		db.close();
		return produkList;
	}
	
	public boolean addProdukTag(String barcode, String tag) {
		SQLiteDatabase db = getWritableDatabase();

		Cursor cursor = db.query(TABLE_PRODUK_TAG, null, "barcode = \"" + barcode + "\"", null, null, null, null);
		if (cursor.getCount() > 0) {
			return false;
		}

		ContentValues values = new ContentValues();
		values.put("barcode", barcode);
		values.put("tag", tag);
		long t = db.insertWithOnConflict(TABLE_PRODUK_TAG, null, values, db.CONFLICT_IGNORE);
		System.out.println(t + "add Produk Tag : " + barcode + " " + tag);
		
		db.close();
		return true;
	}
	
	public boolean addSupermarket(String id, String nama_supermarket) {
		SQLiteDatabase db = getWritableDatabase();

		Cursor cursor = db.query(TABLE_SUPERMARKET, null, "id = \"" + id + "\"", null, null, null, null);
		if (cursor.getCount() > 0) {
			return false;
		}

		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("nama_supermarket", nama_supermarket);
		long t = db.insertWithOnConflict(TABLE_SUPERMARKET, null, values, db.CONFLICT_IGNORE);
		System.out.println(t + "add Supermarket : " + id + " " + nama_supermarket);
		
		db.close();
		return true;
	}
	
	public List<Supermarket> getAllSupermarket() {
		SQLiteDatabase db = getReadableDatabase();

		List<Supermarket> supermarketList = new ArrayList<Supermarket>();
		Cursor cursor = db.query(TABLE_SUPERMARKET, null, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			System.out.println("getAllSupermarket " + cursor.getString(cursor.getColumnIndex("nama_supermarket")));
			supermarketList.add(new Supermarket(getAllProduk(cursor.getString(cursor.getColumnIndex("nama_supermarket"))),
					cursor.getString(cursor.getColumnIndex("nama_supermarket"))));
			cursor.moveToNext();
		}
		
		cursor.close();
		db.close();
		return supermarketList;
	}

	public boolean addProdukSupermarket(String id, String barcode, long harga) {
		SQLiteDatabase db = getWritableDatabase();

		Cursor cursor = db.query(TABLE_PRODUK_SUPERMARKET, null, "barcode = \"" + barcode + "\"", null, null, null, null);
		if (cursor.getCount() > 0) {
			return false;
		}

		ContentValues values = new ContentValues();
		values.put("id", id);
		values.put("barcode", barcode);
		values.put("harga", harga);
		long t = db.insertWithOnConflict(TABLE_PRODUK_SUPERMARKET, null, values, db.CONFLICT_IGNORE);
		System.out.println(t + "add Produk Supermarket : " + id + " " + barcode + " " + harga);
		
		db.close();
		return true;
	}
	
}
