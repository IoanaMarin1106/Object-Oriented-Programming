package tema3;

public class DisplayScore implements Visitor{
	
	private int minimScore;
	private int maximScore;
	
	public void Score(Team team) {
		int minimScore = team.getPlayers().get(0).getScore();
		int maximScore = minimScore;
		
		for (Player p : team.getPlayers()) {
			if (minimScore > p.getScore()) {
				minimScore = p.getScore();
			}
			
			if (maximScore < p.getScore()) {
				maximScore = p.getScore();
			}
		}
		
		this.maximScore = maximScore;
		this.minimScore = minimScore;
	}
	
	public int scoreSum(Team team) {
		int scoreSum = 0;
		
		for (Player p : team.getPlayers()) {
			scoreSum += p.getScore();
		}
		
		return scoreSum;
	}
	
	public int productScore(Team team) {
		int productScore = 1;
		
		for (Player p : team.getPlayers()) {
			productScore *= p.getScore();
		}
		
		return productScore;
	}
	
	@Override
	public int score(FootballTeam team) {
		this.Score(team);
		if (team.getGender().equals("feminin")) {
			return this.minimScore + this.scoreSum(team);
		} else {
			return this.maximScore + this.scoreSum(team);
		}
	}

	@Override
	public double score(BasketballTeam team) {
		double scoreSum = this.scoreSum(team);
		double numberOfPlayers = team.getNumberOfPlayers();
		return scoreSum / numberOfPlayers;
	}

	@Override
	public int score(HandballTeam team) {
		if (team.getGender().equals("feminin")) {
			return this.productScore(team);
		} else {
			return this.scoreSum(team);
		}
	}
}
