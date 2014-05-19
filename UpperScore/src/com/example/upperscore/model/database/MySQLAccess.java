package com.example.upperscore.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.AsyncTask;

import com.example.upperscore.model.Barcode;
import com.example.upperscore.model.Produk;
import com.example.upperscore.model.Source;
import com.example.upperscore.model.Supermarket;

public class MySQLAccess {
	private static final String DATABASE_NAME = "caers_oop";

	private static final String TABLE_PRODUK = "produk";
	private static final String TABLE_PRODUK_TAG = "produk_tag";
	private static final String TABLE_SUPERMARKET = "supermarket";
	private static final String TABLE_PRODUK_SUPERMARKET = "produk_supermarket";

	private static String ID_SUPERMARKET = "10000";

	private Connection connect;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private Produk produk;

	public MySQLAccess() {

		//createDatabase();
	}

	/** Getters */
	public Produk getProduk(String nama_supermarket, Barcode barcode) {
		new GetProduk(nama_supermarket, barcode).execute();
		return produk;
	}

	public GetAllProduk getAllProduk(String nama_supermarket) {
		return new GetAllProduk(nama_supermarket);
	}

	public void AddProduk(String barcode, String nama_produk) {
		new AddProduk(barcode, nama_produk);
	}

	public void AddProdukTag(String barcode, String tag) {
		new AddProduk(barcode, tag);
	}

	public void AddSupermarket(String nama_supermarket) {
		new AddSupermarket(nama_supermarket);
	}

	public void AddSupermarketProduk(String id, String barcode, String harga) {
		new AddSupermarketProduk(id, barcode, harga);
	}

	public void getAllSupermarket() {
		new GetAllSupermarket().execute("");
	}

	/** Other Methods */
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createDatabase() {
		String DROP_TABLE_PRODUK = "DROP TABLE IF EXISTS " + TABLE_PRODUK + ";";
		String CREATE_TABLE_PRODUK = "CREATE TABLE " + TABLE_PRODUK + " ("
				+ "barcode varchar(20) NOT NULL, "
				+ "nama_produk varchar(255) NOT NULL, "
				+ "PRIMARY KEY (barcode)" + ");";

		String DROP_TABLE_PRODUK_TAG = "DROP TABLE IF EXISTS "
				+ TABLE_PRODUK_TAG + ";";
		String CREATE_TABLE_PRODUK_TAG = "CREATE TABLE " + TABLE_PRODUK_TAG
				+ " (" + "barcode varchar(20) NOT NULL, "
				+ "tag varchar(255) NOT NULL, " + "PRIMARY KEY (barcode)"
				+ ");";

		String DROP_TABLE_SUPERMARKET = "DROP TABLE IF EXISTS "
				+ TABLE_SUPERMARKET + ";";
		String CREATE_TABLE_SUPERMARKET = "CREATE TABLE " + TABLE_SUPERMARKET
				+ " (" + "id varchar(20) NOT NULL, "
				+ "nama_supermarket varchar(255) NOT NULL, "
				+ "PRIMARY KEY (id)" + ");";

		String DROP_TABLE_PRODUK_SUPERMARKET = "DROP TABLE IF EXISTS "
				+ TABLE_PRODUK_SUPERMARKET + ";";
		String CREATE_TABLE_PRODUK_SUPERMARKET = "CREATE TABLE "
				+ TABLE_PRODUK_SUPERMARKET + " (" + "id varchar(20) NOT NULL, "
				+ "barcode varchar(20) NOT NULL, " + "harga int(9) NOT NULL, "
				+ "PRIMARY KEY (id, barcode)" + ");";

		try {
			connect.setAutoCommit(false);
			statement = connect.createStatement();
			statement.addBatch(DROP_TABLE_PRODUK);
			statement.addBatch(DROP_TABLE_PRODUK_TAG);
			statement.addBatch(DROP_TABLE_SUPERMARKET);
			statement.addBatch(DROP_TABLE_PRODUK_SUPERMARKET);
			statement.addBatch(CREATE_TABLE_PRODUK);
			statement.addBatch(CREATE_TABLE_PRODUK_TAG);
			statement.addBatch(CREATE_TABLE_SUPERMARKET);
			statement.addBatch(CREATE_TABLE_PRODUK_SUPERMARKET);
			statement.executeBatch();
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Inner Class */
	private class GetProduk extends AsyncTask<Produk, String, Produk> {
		private String nama_supermarket;
		private Barcode barcode;

		public GetProduk(String nama_supermarket, Barcode barcode) {
			this.nama_supermarket = nama_supermarket;
			this.barcode = barcode;
		}

		@Override
		protected Produk doInBackground(Produk... params) {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");
	
				// setup the connection with the DB.
				connect = DriverManager.getConnection(
						"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
						"Suk5e$");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Produk produk = new Produk();
			try {
				preparedStatement = connect.prepareStatement("SELECT * FROM "
						+ TABLE_PRODUK + " NATURAL JOIN " + TABLE_SUPERMARKET + " NATURAL JOIN " + TABLE_PRODUK_SUPERMARKET
						+ " WHERE nama_supermarket = \"" + nama_supermarket + "\" AND barcode = \"" + barcode.getId() + "\"");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					List<String> tag = new ArrayList<String>();
					tag = Arrays.asList(resultSet.getString("tag").split(" *, *"));
					produk = new Produk(new Barcode(resultSet
							.getString("barcode")), resultSet
							.getString("nama_produk"), resultSet.getInt("harga"),
							tag);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produk;
		}
		
		@Override
		protected void onPostExecute(Produk result) {
			super.onPostExecute(result);
			produk = result;
		}
		
	}

	private class GetAllProduk extends AsyncTask<Produk, String, List<Produk> > {
		private String nama_supermarket;
		
		public GetAllProduk(String nama_supermarket) {
			this.nama_supermarket = nama_supermarket;
		}
		
		@Override
		protected List<Produk> doInBackground(Produk... params) {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");

				// setup the connection with the DB.
				connect = DriverManager.getConnection(
						"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
						"Suk5e$");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			List<Produk> produkList = new ArrayList<Produk>();

			try {
				preparedStatement = connect.prepareStatement("SELECT * FROM "
						+ TABLE_PRODUK + " NATURAL JOIN " + TABLE_SUPERMARKET + " NATURAL JOIN " + TABLE_PRODUK_SUPERMARKET
						+ " WHERE nama_supermarket = \"" + nama_supermarket + "\"");
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					List<String> tag = new ArrayList<String>();
					tag = Arrays.asList(resultSet.getString("tag").split(" *, *"));
					Produk produk = new Produk(new Barcode(resultSet
							.getString("barcode")), resultSet
							.getString("nama_produk"), resultSet.getInt("harga"),
							tag);
					produkList.add(produk);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return produkList;
		}
	}

	private class AddProduk extends AsyncTask<String, String, String> {
		private String barcode;
		private String nama_produk;
		
		public AddProduk(String barcode, String nama_produk) {
			this.barcode = barcode;
			this.nama_produk = nama_produk;
		}
		
		@Override
		protected String doInBackground(String... params) {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");

				// setup the connection with the DB.
				connect = DriverManager.getConnection(
						"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
						"Suk5e$");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				preparedStatement = connect.prepareStatement("INSERT INTO "
						+ TABLE_PRODUK + " VALUES(?, ?)");
				preparedStatement.setString(1, barcode);
				preparedStatement.setString(2, nama_produk);
				resultSet = preparedStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "";
		}
	}

	private class AddProdukTag extends AsyncTask<String, String, String> {
		private String barcode;
		private String tag;
		
		public AddProdukTag(String barcode, String tag) {
			this.barcode = barcode;
			this.tag = tag;
		}
		
		@Override
		protected String doInBackground(String... params) {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");

				// setup the connection with the DB.
				connect = DriverManager.getConnection(
						"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
						"Suk5e$");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				preparedStatement = connect.prepareStatement("INSERT INTO "
						+ TABLE_PRODUK_TAG + " VALUES(?, ?)");
				preparedStatement.setString(1, barcode);
				preparedStatement.setString(2, tag);
				resultSet = preparedStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "";
		}
	}

	private class AddSupermarket extends AsyncTask<String, String, String> {
		private String nama_supermarket;
		
		public AddSupermarket(String nama_supermarket) {
			this.nama_supermarket = nama_supermarket;
		}
		
		@Override
		protected String doInBackground(String... params) {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");

				// setup the connection with the DB.
				connect = DriverManager.getConnection(
						"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
						"Suk5e$");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ID_SUPERMARKET = String.valueOf(Integer.parseInt(ID_SUPERMARKET) + 1);
			try {
				preparedStatement = connect.prepareStatement("INSERT INTO "
						+ TABLE_PRODUK_TAG + " VALUES(?, ?)");
				preparedStatement.setString(1, ID_SUPERMARKET);
				preparedStatement.setString(2, nama_supermarket);
				resultSet = preparedStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "";
		}
	}

	private class AddSupermarketProduk extends AsyncTask<String, String, String> {
		private String id;
		private String barcode;
		private String harga;
		
		public AddSupermarketProduk(String id, String barcode, String harga) {
			this.id = id;
			this.barcode = barcode;
			this.harga = harga;
		}
		
		@Override
		protected String doInBackground(String... params) {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");

				// setup the connection with the DB.
				connect = DriverManager.getConnection(
						"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
						"Suk5e$");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ID_SUPERMARKET = String.valueOf(Integer.parseInt(ID_SUPERMARKET) + 1);
			try {
				preparedStatement = connect.prepareStatement("INSERT INTO "
						+ TABLE_PRODUK_TAG + " VALUES(?, ?, ?)");
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, barcode);
				preparedStatement.setString(3, harga);
				resultSet = preparedStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "";
		}
	}

	private class GetAllSupermarket extends AsyncTask<String, String, List<Supermarket> > {

		public GetAllSupermarket() {}
		
		@Override
		protected List<Supermarket> doInBackground(String... params) {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");

				// setup the connection with the DB.
				connect = DriverManager.getConnection(
						"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
						"Suk5e$");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			List<String> snameList = new ArrayList<String>();
			
			try {
				preparedStatement = connect.prepareStatement("SELECT * FROM " + TABLE_SUPERMARKET);
				resultSet = preparedStatement.executeQuery();
		
				while (resultSet.next()) {
					snameList.add(resultSet.getString("nama_supermarket"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			List<Supermarket> supermarketList = new ArrayList<Supermarket>();

			try {
				for (String sname : snameList) {
					List<Produk> produkList = new ArrayList<Produk>();
					
					preparedStatement = connect
							.prepareStatement("SELECT * FROM " + TABLE_PRODUK
									+ " NATURAL JOIN " + TABLE_SUPERMARKET
									+ " NATURAL JOIN " + TABLE_PRODUK_SUPERMARKET
									+ " WHERE nama_supermarket = \"" + sname
									+ "\"");
					resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {
						List<String> tag = new ArrayList<String>();
						tag = Arrays.asList(resultSet.getString("tag").split(" *, *"));
						Produk produk = new Produk(new Barcode(resultSet
								.getString("barcode")), resultSet
								.getString("nama_produk"), resultSet.getInt("harga"),
								tag);
						produkList.add(produk);
					}
					supermarketList.add(new Supermarket(produkList, sname));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return supermarketList;
		}
		
		@Override
		protected void onPostExecute(List<Supermarket> result) {
			super.onPostExecute(result);
			Source.getInstance().setSupermarketList(result);
		}
	}

}
