
public class Betting {
	
	private double currentBalance;
	private IRandomValueGenerator gen;
	private int minBalance;
	
	public Betting (int minBalance, IRandomValueGenerator gen){
		this.minBalance=minBalance;
		this.gen=gen;
		this.currentBalance=0;
	}
	
	public double getCurrentBalance() {
		 return currentBalance;
	}
	
	public void addMoney(int amnt){
		throw new RuntimeException();
	}
	//returns true for a win, false for a loss
	public boolean betOnANumber(int amnt, int min, int max, int selectedNumber) {
		throw new RuntimeException();
	}
			
	public boolean betOnProbability(int amnt, double p){ 
		throw new RuntimeException();
	}
}
