package de.headblaster.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;



public class MySQL {

	public static String host;
	public static String port;
	public static String database;
	public static String username;
	public static String password;
	public static Connection con;
	
	public static void connect() {
		
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,username,password);
			Bukkit.getConsoleSender().sendMessage("§aVerbindung zu MySQL Datenbank aufgebaut");
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			Bukkit.getConsoleSender().sendMessage("§cVerbindung zu MySQL Datenbank konnte nicht aufgebaut werden!");
			
		}
		
	}
	
	public static Connection getConnection() {
		
		return con;
		
	}
	
	public static PreparedStatement getStatement(String qry) {
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(qry);
			return ps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return null;
	}
	
      public static void update(String qry) {
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(qry);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getResult(String qry) {
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(qry);
			ps.executeUpdate();
			return ps.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
