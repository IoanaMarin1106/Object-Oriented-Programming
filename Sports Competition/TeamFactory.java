package tema3;

public class TeamFactory {
	private static final String FOOTBALL = "football";
	private static final String BASKETBALL = "basketball";
	private static final String HANDBALL = "handball";
	
	public static Team getTeam(String teamType) {
		
		switch(teamType) {
		case FOOTBALL:
			return new FootballTeam();
		case BASKETBALL:
			return new BasketballTeam();
		case HANDBALL:
			return new HandballTeam();
		}
		return null;
	}
}
