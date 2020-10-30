package tema3;

public class BasketballTeam extends Team implements AcceptVisitor{

	public BasketballTeam() {
		super();
	}
	
	@Override
	public double accept(Visitor visitor) {
		return visitor.score(this);
	}
}
