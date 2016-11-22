package de.headblaster.scoreboard;

import java.sql.PreparedStatement;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.headblaster.mysql.MySQL;
import de.headblaster.mysql.MySQLFile;

public class SimpleScoreboard extends JavaPlugin{

	@Override
	public void onEnable() {
		
		Bukkit.getConsoleSender().sendMessage("[" + this.getDescription().getName() + "] aktiviert");
		
		MySQLFile file = new MySQLFile();
		file.setStandard();
		file.readData();
		
		MySQL.connect();
		
		MySQL.update("CREATE TABLE IF NOT EXISTS SimpleScoreboard (username VARCHAR(100),uuid VARCHAR(100),deaths VARCHAR(100),kills VARCHAR(100))");
		
		try {
	    PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO SimpleScoreboard (username,uuid,deaths,kills) VALUES ('Name','UUID','10','10')"); 
		ps.executeUpdate();
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
}
