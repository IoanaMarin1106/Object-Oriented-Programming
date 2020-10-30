package tema3;

import java.util.*;

public class RankingObserver extends Observer{

	public RankingObserver(Ranking ranking) {
		this.ranking = ranking;
		this.ranking.attach(this);
	}
	
	@Override
	public void update() {
		
		@SuppressWarnings("unchecked")
		ArrayList<Team> rankingList = (ArrayList<Team>) ranking.getTeams().clone();
		Collections.sort(rankingList);
		Collections.reverse(rankingList);
		
		ranking.setTeams(rankingList);
		
		for (int i = 0; i < ranking.getTeams().size(); i++) {
			Team t = ranking.getTeams().get(i);
			t.setRankingPlace(i + 1);	
		}
	}
}
