package tema3;

import java.util.*;

public class AllTeams {
	
	private HashMap<String, Team> teams;
	private ArrayList<String> teamsNames;
	
	public ArrayList<String> getTeamsNames() {
		return teamsNames;
	}

	public void setTeamsNames(ArrayList<String> teamsNames) {
		this.teamsNames = teamsNames;
	}

	private static AllTeams instance = new AllTeams();
	
	private AllTeams() {
		teams = new HashMap<String, Team>();
		teamsNames = new ArrayList<String>();
	}
	
	public static AllTeams getInstance() {
		return instance;
	}

	public void put(String teamName, Team team) {
		teams.put(teamName, team);
	}
	
	public Team getTeam(String teamName) {
		return teams.get(teamName);
	}
	
	public boolean isEmpty() {
		return teams.isEmpty();
	}
	
	public HashMap<String, Team> getTeams() {
		return teams;
	}
}
