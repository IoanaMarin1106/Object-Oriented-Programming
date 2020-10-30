package tema3;

import java.util.*;
import java.io.*;

public class Team implements Comparable<Team>, Cloneable{

	private String teamName;
	private String teamType;
	private String gender;
	private int numberOfPlayers;
	private ArrayList<Player> players;
	private int rankingPlace;
	private int scorePoints;
	
	protected Team() {
		this.teamName = "";
		this.teamType = "";
		this.gender = "";
		this.numberOfPlayers = 0;
		this.players = new ArrayList<Player>();
		this.rankingPlace = 0;
		this.scorePoints = 0;
	}

	public String getTeamType() {
		return teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public int getScorePoints() {
		return scorePoints;
	}

	public void setScorePoints(int scorePoints) {
		this.scorePoints = scorePoints;
	}

	public int getRankingPlace() {
		return rankingPlace;
	}

	public void setRankingPlace(int rankingPlace) {
		this.rankingPlace = rankingPlace;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public void listTeam(PrintWriter writer) {
		writer.print("{teamName: " + this.teamName + ",");
		writer.print(" gender: " + this.gender + ",");
		writer.print(" numberOfPlayers: " + this.numberOfPlayers + ",");
		writer.print(" players: [");
		
		int sizeOfPlayers = players.size();
		
		for(Player p : players) {
			
			writer.print("{name: " + p.getName() + ",");
			writer.print(" score: " + p.getScore() + "}");
			
			if (sizeOfPlayers == 1) {
				writer.println("]}");
			} else {
				writer.print(", ");
			}
			
			sizeOfPlayers -= 1;
		}
	}
	
	public boolean checkTeam(Competition competition) {
		
		if (this.getGender().equals(competition.getGender())) {
			
			if (this instanceof FootballTeam && competition.getType().equals("football")) {
				return true;
			}
			
			if (this instanceof BasketballTeam && competition.getType().equals("basketball")) {
				return true;
			}
			
			if (this instanceof HandballTeam && competition.getType().equals("handball")) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	@Override
	public int compareTo(Team o) {
		return this.scorePoints - o.scorePoints;
	}

	@Override
	protected Team clone() throws CloneNotSupportedException {
		return (Team) super.clone();
	}
}
