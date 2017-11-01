

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BettingGame_Tests {
	
		MockGenerator gen;
		Betting bet;
		
	@Before 
	public void setUp(){
		gen=new MockGenerator();
		bet=new Betting (0, gen);	
	}
	
	@Test
	public void add50IncreasesBalancesBy50(){
		bet.addMoney(50);
		assertTrue(bet.getCurrentBalance()==50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negativeNumberThrowsException(){
		bet.addMoney(-50);
	}
	
	@Test
	public void winsNumberBetBalanceGoesUpByRangeMinus1TimesAmt(){
		bet.addMoney(200);
		gen.setValue(19);
		bet.betOnANumber(100, 10, 19, 19);
		assertEquals(1100,bet.getCurrentBalance(),0001);
	}
	
	@Test
	public void losesNumberBetBalanceGoesDownByBetAmount(){
		bet.addMoney(150);
		gen.setValue(15);
		bet.betOnANumber(100, 10, 19, 14);
		assertTrue(bet.getCurrentBalance()==50.00);
	}
	
	@Test
	public void winsProbabilityBetBalanceIncreasesbyProperAmount(){
		bet.addMoney(200);
		gen.setBoolean(true);
		bet.betOnProbability(100,0.3);
		assertEquals(433, bet.getCurrentBalance(), 0001);
	}
	@Test
	public void losesProbabilityBetBalanceDecreasesbyBetAmount(){
		bet.addMoney(150);
		gen.setBoolean(false);
		bet.betOnProbability(100, 0.3);
		assertTrue(bet.getCurrentBalance()==50);
	}
	
	@Test(expected=InvalidProbabilityException.class)
	public void negativeProbabilityThrowsException(){
		bet.betOnProbability(100, -.02);
	}
	@Test(expected=InvalidProbabilityException.class)
	public void ProbabilityGreaterThan1ThrowsException(){
		bet.betOnProbability(100, 2);
	}
	@Test(expected=InsufficientFundsException.class)
	public void BetWithInsufficientFundsToCoverLossThrowsException(){
		bet.addMoney(30);
		bet.betOnANumber(100, 1, 50, 49);
	}
}
