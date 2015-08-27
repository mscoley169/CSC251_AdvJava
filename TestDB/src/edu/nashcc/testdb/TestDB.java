package edu.nashcc.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

	public static void main(String[] args) {
	
		try{
		Class.forName("src.main.java.net.ucanaccess.jdbc.UcanaccessDriver");
			Connection conn=DriverManager.getConnection(
		        "jdbc:ucanaccess://C:/Users/mscoley169/Documents/Databases/jdbc_book.mdb", "jdbc_book", "guest");
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT [LastName] FROM [Clients]");
		while (rs.next()) {
		    System.out.println(rs.getString(1));
		} }catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
}
