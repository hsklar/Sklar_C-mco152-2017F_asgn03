import java.util.Scanner;
public class UseBetting {

	
	public static void main (String []args){
		RealGenerator gen=new RealGenerator();
		Betting bet=new Betting (0, gen);
		Scanner keyboard=new Scanner(System.in);
		
		System.out.println("Enter the amount of money you'd like to begin with");
		double money=keyboard.nextDouble();
		bet.addMoney(money);
		
		System.out.println("Enter the probability that it will rain");
		double prob=keyboard.nextDouble();
		System.out.println("Enter the amount you want to bet");
		int amnt=keyboard.nextInt();
		boolean bet1=bet.betOnProbability(amnt, prob);
		System.out.println("You won bet1: "+bet1+ ". Your balance is currently " +bet.getCurrentBalance());
		
		System.out.println("Enter a number between 1 & 10 inclusive");
		int num=keyboard.nextInt();
		System.out.println("Enter the amount you want to bet");
		amnt=keyboard.nextInt();
		boolean bet2=bet.betOnANumber(amnt, 1, 10, num);
		System.out.println("You won bet2: "+bet2+ ". Your balance is currently " +bet.getCurrentBalance());	
		
		System.out.println("Thank you for playing!");
	}
}
