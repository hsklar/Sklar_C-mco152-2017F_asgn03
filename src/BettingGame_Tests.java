

import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

public class BettingGame_Tests {
	//The @Before annotation didn't work in this configuration enviornment
	//I had to change it since the tests are in the same folder as the methods their testing
		MockGenerator gen=new MockGenerator();
		Betting bet=new Betting (0, gen);
	
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
		gen.setValue(19);
		bet.betOnANumber(100, 10, 19, 19);
		assertEquals(900,bet.getCurrentBalance(),0001);
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
		gen.setBoolean(true);
		bet.betOnProbability(100,0.3);
		assertEquals(233, bet.getCurrentBalance(), 0001);
	}
	@Test
	public void losesProbabilityBetBalanceDecreasesbyBetAmount(){
		bet.addMoney(150);
		gen.setValue(90);
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

}
