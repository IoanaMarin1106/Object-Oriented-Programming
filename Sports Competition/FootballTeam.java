package tema3;

public class FootballTeam extends Team implements AcceptVisitor {
	
	public FootballTeam() {
		super();
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.score(this);
	}
}
