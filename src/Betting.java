
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
	
	public void addMoney(double amnt){
		if (amnt<0){
			throw new IllegalArgumentException();
		}
		currentBalance+=amnt;
	}
	//returns true for a win, false for a loss
	public boolean betOnANumber(int amnt, int min, int max, int selectedNumber) {
		if (currentBalance-amnt<minBalance){
			throw new InsufficientFundsException();
		}

		int val=gen.getValue(min, max);
		if (selectedNumber==val){
			currentBalance+=(max-min)*amnt;
			return true;
		}
		currentBalance-=amnt;
		return false;
	}
	//returns true for a win, false for a loss		
	public boolean betOnProbability(int amnt, double p){ 
		if (p<0 || p>1){
			throw new InvalidProbabilityException();
		}
		if (currentBalance-amnt<minBalance){
			throw new InsufficientFundsException();
		}
		boolean winLoss=gen.getBoolean(p);
		if (winLoss==true){
			double increaseAmt= (Math.pow(p,-1)-1)*amnt;
			currentBalance+=increaseAmt;
			return true;
		}
		currentBalance-=amnt;
		return false;
	
	}
}
