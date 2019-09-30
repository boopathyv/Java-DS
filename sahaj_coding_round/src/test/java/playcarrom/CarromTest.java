package playcarrom;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import starter.CarromBoard;

class CarromTest {
	
	private CarromBoard carrom = new CarromBoard();
	
	// Test Case : for single strike to result with draw finally
	@Test
	public void test1() {
		Integer[] inputs = new Integer[] {1,1,1,3,1,1,1,1,1,1,1};
		String result = carrom.playCarrom(inputs);
		assertTrue("Draw, score 6/7".equals(result));
	}
	
	// test case with few multi-strike by player2
	@Test
	public void test2() {
		Integer[] inputs = new Integer[] {1,2,1,3,1,2,1,2};
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 2 wins, score 2/5".equals(result));	
	}

	//	Test Case : Red strike - When a player pockets red coin he/she wins 3 points. 
	//	If other coins are pocketed along with red coin in the same turn, 
	//	other coins get back on to the carrom-board
	@Test
	public void test31() {
		Integer[] inputs = new Integer[] {1,1,3,1,1,2,1,2,1,2};// red follows single strike
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 1 wins, score 5/2".equals(result));
	}
	
	@Test
	public void test32() {
		Integer[] inputs = new Integer[] {1,1,3,1,2,1,2,1,2};// red follows multi strike
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 1 wins, score 6/2".equals(result));
	}
	
	@Test
	public void test33() {
		Integer[] inputs = new Integer[] {1,1,3,1,4,1,2,1,2};// red follows striker strike
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 1 wins, score 7/4".equals(result));
	}
	
	@Test
	public void test34() {
		Integer[] inputs = new Integer[] {1,1,3,1,5,1,2,1,2};// red follows defunct strike
		String result = carrom.playCarrom(inputs);
		assertTrue("Draw, score 6/4".equals(result));
	}
	
	@Test
	public void test35() {
		Integer[] inputs = new Integer[] {3,1,6,1,6,2,6,1};// red follows no strike
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 2 wins, score 2/5".equals(result));
	}
	
	// Test Case : Striker strike - When a player pockets the striker he/she loses a point
	@Test
	public void test4() {
		Integer[] inputs = new Integer[] {2, 4, 2, 4, 1};
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 1 wins, score 5/-2".equals(result));
	}
	
	// Test Case : Defunct coin - When a coin is thrown out of the carrom-board, 
	// due to a strike, the player loses 2 points, and the coin goes out of play
	@Test
	public void test5() {
		Integer[] inputs = new Integer[] {2, 5, 2, 5, 1};
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 1 wins, score 5/-4".equals(result));
	}
	
	// Test Case : When a player does not pocket a coin for 3 successive turns he/she loses a point
	@Test
	public void test6() {
		Integer[] inputs = new Integer[] {1, 6, 1, 6, 1, 6, 1, 6, 1};
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 1 wins, score 5/-1".equals(result));
	}
	
	// Test Case : When a player fouls 3 times 
	// (a foul is a turn where a player loses, at least, 1 point), he/she loses an additional point
	@Test
	public void test7() {
		Integer[] inputs = new Integer[] {4, 2, 5, 2, 4, 2};
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 2 wins, score -6/6".equals(result));
	}
	
	// Test cases : A game is won by the first player to have won at least 5 points, 
	// in total, and, at least, 3 points more than the opponent
	// When the coins are exhausted on the board, if the highest scorer is not leading by, 
	// at least, 3 points or does not have a minimum of 5 points, the game is considered a draw
	@Test
	public void testPlayer1Win() {
		Integer[] inputs = new Integer[] {1,1,3,1,4,1,2,1,2};
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 1 wins, score 7/4".equals(result));
	}
	
	@Test
	public void testPlayer2Win() {
		Integer[] inputs = new Integer[] {3,1,6,1,6,2,6,1};
		String result = carrom.playCarrom(inputs);
		assertTrue("Player 2 wins, score 2/5".equals(result));
	}
	
	@Test
	public void testToDraw() {
		Integer[] inputs = new Integer[] {1,1,3,1,5,1,2,1,2};
		String result = carrom.playCarrom(inputs);
		assertTrue("Draw, score 6/4".equals(result));
	}
	
}
