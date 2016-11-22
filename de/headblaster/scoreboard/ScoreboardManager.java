package de.headblaster.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

	public Player p;
	
	public ScoreboardManager(Player p) {
		
		this.p = p;
		
	}
	
	public void loadScoreboard() {
		
		Scoreboard sc = Bukkit.getScoreboardManager().getNewScoreboard();
		
		Objective obj = sc.getObjective("abc");
		
		Score s1 = obj.getScore("Deaths: %%");
		Score s2 = obj.getScore("Kills");
		Score s3 = obj.getScore("KD");
		
		s1.setScore(2);
		s2.setScore(1);
		s3.setScore(0);
		
		p.setScoreboard(sc);
		
	}
	
}
