package UpperScore;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  @SuppressWarnings("deprecation")
public void readDataBase() throws Exception {
    try {
      // this will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // setup the connection with the DB.
      connect = DriverManager.getConnection("jdbc:mysql://localhost/perkuliahan?"+"user=root&password=");
      
      // statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // resultSet gets the result of the SQL query
      
      resultSet = statement.executeQuery("select * from PERKULIAHAN.MAHASISWA");
      writeResultSet(resultSet);
      
      // preparedStatements can use variables and are more efficient
      preparedStatement = connect.prepareStatement("insert into  PERKULIAHAN.MAHASISWA values ('aa', ?, ?, ?, ? , ?, ?)");
      
      // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      // parameters start with 1
      preparedStatement.setString(1, "Test");
      preparedStatement.setString(2, "T");
      preparedStatement.setString(3, "Test");
      preparedStatement.setString(4, "ayam");
      preparedStatement.setString(5, "Te");
      preparedStatement.setString(6, "Test");
    //  preparedStatement.executeUpdate();
      
/*
      preparedStatement = connect.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      resultSet = preparedStatement.executeQuery();
      writeResultSet(resultSet);

      // remove again the insert comment
      preparedStatement = connect.prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
      preparedStatement.setString(1, "Test");
      preparedStatement.executeUpdate();
      */    
  
      resultSet = statement.executeQuery("select * from perkuliahan.dosen");
      writeMetaData(resultSet);
  } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    // now get some metadata from the database
    System.out.println("The columns in the table are: ");
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // resultSet is initialised before the first data set
    while (resultSet.next()) {
      // it is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g., resultSet.getSTring(2);
      String user = resultSet.getString("nim");
      String website = resultSet.getString("nama");
      System.out.println("nim: " + user);
      System.out.println("nama " + website);
    }
  }

  // you need to close all three to make sure
  private void close() throws SQLException {
    resultSet.close();
    statement.close();
    connect.close();
  }
  
  private void close(Closeable c) {
    try {
      if (c != null) {
        c.close();
      }
    } catch (Exception e) {
    // don't throw now as it might leave following closables in undefined state
    }
  }
}
