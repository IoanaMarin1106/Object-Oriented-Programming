package tema3;

import java.util.ArrayList;

public class Ranking {
	private ArrayList<Team> teams;
	private ArrayList<Observer> observers;
	
	public Ranking() {
		this.teams = new ArrayList<Team>();
		this.observers = new ArrayList<Observer>();
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
	public void modifyRanking() {
		notifyAllObserver();
	}
	
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyAllObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
