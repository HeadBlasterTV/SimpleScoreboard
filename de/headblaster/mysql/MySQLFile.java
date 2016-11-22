package de.headblaster.mysql;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.headblaster.scoreboard.SimpleScoreboard;

public class MySQLFile {

	public static File file = new File("plugins/" + SimpleScoreboard.getPlugin(SimpleScoreboard.class).getDescription().getName(),"config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public void setStandard() {
		
		if(getFile().exists() == false) {
		
		getConfig().set("MySQL.host", "localhost");
		getConfig().set("MySQL.port", "3306");
		getConfig().set("MySQL.database", "database");
		getConfig().set("MySQL.username", "root");
		getConfig().set("MySQL.password", "12345678");
		
		try {
			getConfig().save(getFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
	
	public void readData() {
		
		MySQL.host = getConfig().getString("MySQL.host");
		MySQL.port = getConfig().getString("MySQL.port");
		MySQL.database = getConfig().getString("MySQL.database");
		MySQL.username = getConfig().getString("MySQL.username");
		MySQL.password = getConfig().getString("MySQL.password");
		
	}
	
	public File getFile() {
		
		return file;
		
	}
	
	public FileConfiguration getConfig() {
		
		return cfg;
		
	}
	
}
