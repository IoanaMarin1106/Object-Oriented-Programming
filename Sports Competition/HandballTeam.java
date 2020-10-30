package tema3;

public class HandballTeam extends Team implements AcceptVisitor{
	
	public HandballTeam() {
		super();
	}

	@Override
	public double accept(Visitor visitor) {
		return visitor.score(this);
	}
}
