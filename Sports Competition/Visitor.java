package tema3;

public interface Visitor {
	public int score(FootballTeam team);
	public double score(BasketballTeam team);
	public int score(HandballTeam team);
}
