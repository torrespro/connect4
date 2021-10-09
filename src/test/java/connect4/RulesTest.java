package connect4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import connect4.models.Board;
import connect4.models.Game;
import connect4.types.TokenColor;
import connect4.models.Rules;
import org.junit.jupiter.api.Test;

public class RulesTest {
	Game game = new Game(1, 7, 6);
	Board board = game.getBoard();
	Rules rules = game.getRules();
	
	
	@Test
	public void horizontalWin() {

		for (int i = 0; i < 4; i++) {
			board.setElement(i, 4, TokenColor.RED);
		}

		assertTrue(game.hasWon());
	}

	@Test
	public void verticalTest() {

		for (int i = 1; i < 5; i++) {
			board.setElement(4, i, TokenColor.RED);
		}

		assertTrue(game.hasWon());
	}
	
	@Test
	public void diagonalTest() {
	
		board.setElement(0, 4, TokenColor.RED);
		board.setElement(1, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.setElement(3, 1, TokenColor.RED);

		assertTrue(game.hasWon());
		board.clearBoard();
		
		board.setElement(4, 4, TokenColor.RED);
		board.setElement(3, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.setElement(1, 1, TokenColor.RED);

		assertTrue(game.hasWon());
		board.clearBoard();
		
		board.setElement(4, 3, TokenColor.RED);
		board.setElement(3, 2, TokenColor.RED);
		board.setElement(2, 1, TokenColor.RED);
		board.setElement(1, 0, TokenColor.RED);

		assertTrue(game.hasWon());
		board.clearBoard();
		
		
		//Three in a row, should return false.
		board.setElement(4, 4, TokenColor.RED);
		board.setElement(3, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);

		assertFalse(game.hasWon());
		board.clearBoard();
		
		
		//Three in a row, should return false
		board.setElement(0, 4, TokenColor.RED);
		board.setElement(1, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);

		assertFalse(game.hasWon());
		board.clearBoard();

	}
	
	@Test
	public void falsePositives() {

		for (int i = 0; i < 5; i++) {
			board.setElement(4, i, TokenColor.RED);
		}
		board.setElement(4, 1, TokenColor.YELLOW);
		// Three in a row but four on the same line. Should return false.

		assertFalse(game.hasWon());
		board.clearBoard();

		for (int i = 0; i < 5; i++) {
			board.setElement(i, 4, TokenColor.RED);
		}
		board.setElement(1, 4, TokenColor.YELLOW);

		assertFalse(game.hasWon());
		
	}
	
	@Test
	public void differentRules() {
		Rules rules = new Rules(5);

		for (int i = 1; i < 4; i++) {
			board.setElement(i, 4, TokenColor.RED);
		}

		assertFalse(game.hasWon());
		
		board.clearBoard();

		for (int i = 0; i < 5; i++) {
			board.setElement(i, 4, TokenColor.RED);
		}

		assertTrue(game.hasWon());
		
	}

}
