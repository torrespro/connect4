package connect4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import connect4.rules.Rules;
import org.junit.jupiter.api.Test;

public class RulesTest {
	Game game = new Game(1, 7, 6);
	Board board = game.getBoard();
	Rules rules = game.getRules();
	
	
	@Test
	public void horizontalWin() {

		board.setElement(3, 4, new Token(TokenColor.RED));
		board.setElement(2, 4, new Token(TokenColor.RED));
		board.setElement(1, 4, new Token(TokenColor.RED));
		board.setElement(0, 4, new Token(TokenColor.RED));

		assertTrue(rules.hasWon(board));
	}

	@Test
	public void verticalTest() {
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(4, 3, new Token(TokenColor.RED));
		board.setElement(4, 2, new Token(TokenColor.RED));
		board.setElement(4, 1, new Token(TokenColor.RED));

		assertTrue(rules.hasWon(board));
	}
	
	@Test
	public void diagonalTest() {
	
		board.setElement(0, 4, new Token(TokenColor.RED));
		board.setElement(1, 3, new Token(TokenColor.RED));
		board.setElement(2, 2, new Token(TokenColor.RED));
		board.setElement(3, 1, new Token(TokenColor.RED));

		assertTrue(rules.hasWon(board));
		board.clearBoard();
		
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(3, 3, new Token(TokenColor.RED));
		board.setElement(2, 2, new Token(TokenColor.RED));
		board.setElement(1, 1, new Token(TokenColor.RED));

		assertTrue(rules.hasWon(board));
		board.clearBoard();
		
		board.setElement(4, 3, new Token(TokenColor.RED));
		board.setElement(3, 2, new Token(TokenColor.RED));
		board.setElement(2, 1, new Token(TokenColor.RED));
		board.setElement(1, 0, new Token(TokenColor.RED));

		assertTrue(rules.hasWon(board));
		board.clearBoard();
		
		
		//Three in a row, should return false.
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(3, 3, new Token(TokenColor.RED));
		board.setElement(2, 2, new Token(TokenColor.RED));

		assertFalse(rules.hasWon(board));
		board.clearBoard();
		
		
		//Three in a row, should return false
		board.setElement(0, 4, new Token(TokenColor.RED));
		board.setElement(1, 3, new Token(TokenColor.RED));
		board.setElement(2, 2, new Token(TokenColor.RED));

		assertFalse(rules.hasWon(board));
		board.clearBoard();

	}
	
	@Test
	public void falsePositives() {
		
		// Three in a row but four on the same line. Should return false.
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(4, 3, new Token(TokenColor.RED));
		board.setElement(4, 2, new Token(TokenColor.RED));
		board.setElement(4, 1, new Token(TokenColor.YELLOW));
		board.setElement(4, 0, new Token(TokenColor.RED));

		assertFalse(rules.hasWon(board));
		board.clearBoard();
		
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(3, 4, new Token(TokenColor.RED));
		board.setElement(2, 4, new Token(TokenColor.RED));
		board.setElement(1, 4, new Token(TokenColor.YELLOW));
		board.setElement(0, 4, new Token(TokenColor.RED));

		assertFalse(rules.hasWon(board));
		
	}
	
	@Test
	public void differentRules() {
		Rules rules = new Rules(game, 5);
		
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(3, 4, new Token(TokenColor.RED));
		board.setElement(2, 4, new Token(TokenColor.RED));
		board.setElement(1, 4, new Token(TokenColor.RED));

		assertFalse(rules.hasWon(board));
		
		board.clearBoard();
		
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(3, 4, new Token(TokenColor.RED));
		board.setElement(2, 4, new Token(TokenColor.RED));
		board.setElement(1, 4, new Token(TokenColor.RED));
		board.setElement(0, 4, new Token(TokenColor.RED));

		assertTrue(rules.hasWon(board));
		
	}

}
