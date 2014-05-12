package UpperScore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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

	public MySQLAccess() {
		/*String DROP_TABLE_PRODUK = "DROP TABLE IF EXISTS " + TABLE_PRODUK + ";";
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

		open();
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
			int[] temp = statement.executeBatch();
			connect.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();*/
	}

	private void open() {
		try {
                    
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// setup the connection with the DB.
			connect = DriverManager.getConnection(
					"jdbc:mysql://192.254.187.77/caers_oop", "caers_oop",
					"Suk5e$");

			// statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			// preparedStatements can use variables and are more efficient
			// preparedStatement = connect.prepareStatement();

			// resultSet gets the result of the SQL query
			// resultSet = preparedStatement.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// CRUD Methods
        private void writeResultSet(ResultSet resultSet) throws SQLException 
        {
            // resultSet is initialised before the first data set
            
            while (resultSet.next()){
                // it is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1
                // e.g., resultSet.getSTring(2);
                String barcode = resultSet.getString("barcode");
                String nama = resultSet.getString("nama_produk");
                String tag = resultSet.getString("tag");
                System.out.println("barcode: " + barcode);
                System.out.println("nama " + nama);
                System.out.println("tag " + tag);
            }
        }
        
	public Produk getProduk(String nama_supermarket, Barcode id) {
		Produk L = new Produk();

		open();
		try {
                	preparedStatement = connect.prepareStatement("SELECT * FROM "
					+ TABLE_PRODUK + " NATURAL JOIN " + TABLE_SUPERMARKET + " NATURAL JOIN "
					+ TABLE_PRODUK_SUPERMARKET + " WHERE nama_supermarket = \""
					+ nama_supermarket+"\" and barcode= \""+id.getId()+ "\";");
			resultSet = preparedStatement.executeQuery();
                        
                        //writeResultSet(resultSet);
                        //8990057408305
                        
                        while(resultSet.next())
                        {  
                            List<String> tag = new ArrayList<>();
                            tag=Arrays.asList(resultSet.getString("tag").split(" *, *"));
                            L.setProduk(new Produk(new Barcode(resultSet.getString("barcode")),
					resultSet.getString("nama_produk"), resultSet
							.getInt("harga"), tag));
                        }
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return L;
	}

	public void addProduk(String barCode, String nama_produk) {
 		open();

		try {
			preparedStatement = connect.prepareStatement("INSERT INTO "
					+ TABLE_PRODUK + " VALUES(?, ?)");
			preparedStatement.setString(1, barCode);
			preparedStatement.setString(2, nama_produk);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
	}

	public void addProdukTag(String barCode, String tag) {
		open();

		try {
			preparedStatement = connect.prepareStatement("INSERT INTO "
					+ TABLE_PRODUK_TAG + " VALUES(?, ?)");
			preparedStatement.setString(1, barCode);
			preparedStatement.setString(2, tag);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
	}

	public void addSupermarket(String nama_supermarket) {
		open();

		ID_SUPERMARKET = String.valueOf(Integer.parseInt(ID_SUPERMARKET) + 1);
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO "
					+ TABLE_PRODUK_TAG + " VALUES(?, ?)");
			preparedStatement.setString(1, ID_SUPERMARKET);
			preparedStatement.setString(2, nama_supermarket);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
	}

	public void addSupermarketProduk(String id, String barCode, String harga) {
		open();

		ID_SUPERMARKET = String.valueOf(Integer.parseInt(ID_SUPERMARKET) + 1);
		try {
			preparedStatement = connect.prepareStatement("INSERT INTO "
					+ TABLE_PRODUK_TAG + " VALUES(?, ?, ?)");
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, barCode);
			preparedStatement.setString(3, harga);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
	}

}
