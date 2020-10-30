package tema3;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Competition {
	private static Competition instance = new Competition();
	
	private String type;
	private String gender;
	private ArrayList<Team> teams;
	private Ranking ranking;
	
	private Competition() {
		this.type = "";
		this.gender = "";
		this.teams = new ArrayList<Team>();
		this.ranking = new Ranking();
	}
	
	public static Competition getInstance() {
		return instance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	@SuppressWarnings("unchecked")
	public void matches() {
		/* Cazul in care avem o competitie de fotbal */
		switch(this.type) {
		case "football":
			for (int i = 0; i < this.teams.size() - 1; i++) {
				FootballTeam team = (FootballTeam) this.teams.get(i);
				
				for (int j = i + 1; j < this.teams.size(); j++) {
					
					FootballTeam anotherTeam = (FootballTeam) this.teams.get(j);
					
					if (team.accept(new DisplayScore()) > anotherTeam.accept(new DisplayScore())) {
						team.setScorePoints(team.getScorePoints() + 3);
						
					} else if (team.accept(new DisplayScore()) < anotherTeam.accept(new DisplayScore())){
						anotherTeam.setScorePoints(anotherTeam.getScorePoints() + 3);
						
					} else {
						team.setScorePoints(team.getScorePoints() + 1);
						anotherTeam.setScorePoints(anotherTeam.getScorePoints() + 1);
					}
					this.ranking.setTeams((ArrayList<Team>) this.teams.clone());
					new RankingObserver(this.ranking);
					ranking.modifyRanking();	
				}
			}
			break;
			
		case "basketball":
			for (int i = 0; i < this.teams.size() - 1; i++) {
				BasketballTeam team = (BasketballTeam) this.teams.get(i);

				for (int j = i + 1; j < this.teams.size(); j++) {
					BasketballTeam anotherTeam = (BasketballTeam) this.teams.get(j);
					
					if (team.accept(new DisplayScore()) > anotherTeam.accept(new DisplayScore())) {
						team.setScorePoints(team.getScorePoints() + 3);

					} else if (team.accept(new DisplayScore()) < anotherTeam.accept(new DisplayScore())){
						anotherTeam.setScorePoints(anotherTeam.getScorePoints() + 3);
					} else if (team.accept(new DisplayScore()) == anotherTeam.accept(new DisplayScore())){
						team.setScorePoints(team.getScorePoints() + 1);
						anotherTeam.setScorePoints(anotherTeam.getScorePoints() + 1);
					}
					
					this.ranking.setTeams((ArrayList<Team>) this.teams.clone());
					new RankingObserver(this.ranking);
					ranking.modifyRanking();
				}
			}
			
			break;
			
		case "handball":
			for (int i = 0; i < this.teams.size() - 1; i++) {
				HandballTeam team = (HandballTeam) this.teams.get(i);
				
				for (int j = i + 1; j < this.teams.size(); j++) {
					
					HandballTeam anotherTeam = (HandballTeam) this.teams.get(j);
					
					if (team.accept(new DisplayScore()) > anotherTeam.accept(new DisplayScore())) {
						team.setScorePoints(team.getScorePoints() + 3);
					} else if (team.accept(new DisplayScore()) < anotherTeam.accept(new DisplayScore())){
						anotherTeam.setScorePoints(anotherTeam.getScorePoints() + 3);
					} else {
						team.setScorePoints(team.getScorePoints() + 1);
						anotherTeam.setScorePoints(anotherTeam.getScorePoints() + 1);
					}
					this.ranking.setTeams((ArrayList<Team>) this.teams.clone());
					new RankingObserver(this.ranking);
					ranking.modifyRanking();
				}
			}
			break;
		}
	}
	
	public void listRaking(PrintWriter writer) {
		for (int i = 0; i < 3; i++) {
			writer.println(ranking.getTeams().get(i).getTeamName());
		}
		
		for (Team t : teams) {
			writer.println("Echipa " + t.getTeamName() + " a ocupat locul " + t.getRankingPlace());
		}
	}
}
