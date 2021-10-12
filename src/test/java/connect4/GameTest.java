package connect4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.models.Board;
import es.torres.connect4.models.Game;
import es.torres.connect4.types.TokenColor;
import es.torres.connect4.models.Rules;
import org.junit.jupiter.api.Test;

public class GameTest {
	private Game game = new Game();
	Board board = game.getBoard();
	final int WIN_CONDITION = 4;
	Rules rules = game.getRules();

//	 @Test
	public void hasWonTest() throws IllegalMoveException {
//		game.startGame();
//
//		assertTrue(game.isFinished());
	}

	@Test
	public void insertTokenTest() {

		for (int i = 0; i < board.getHeight(); i++) {
			board.setElement(0, i, TokenColor.RED);

		}

		for (int i = 0; i < board.getHeight(); i++) {
			TokenColor tc = (TokenColor) board.getElement(0, i);
			assertEquals(tc, TokenColor.RED);
		}

	}

	@Test
	public void horizontalWin() {
		board.initializeBoard();
		Rules rules = new Rules(4);

		for (int i = 0; i < 4; i++) {
			board.setElement(i, 4, TokenColor.RED);
		}

		assertTrue(winCondition(board));
		assertTrue(rules.checkHorizontal(board, 4));
	}

	@Test
	public void verticalTest() {

		for (int i = 1; i < 5; i++) {
			board.setElement(4, i, TokenColor.RED);
		}

		assertTrue(winCondition(board));
	}
	
	@Test
	public void diagonalTest() {
	
		board.setElement(0, 4, TokenColor.RED);
		board.setElement(1, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.setElement(3, 1, TokenColor.RED);

		assertTrue(winCondition(board));
		board.clearBoard();
		
		board.setElement(4, 4, TokenColor.RED);
		board.setElement(3, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.setElement(1, 1, TokenColor.RED);

		assertTrue(winCondition(board));
		board.clearBoard();
		
		board.setElement(4, 3, TokenColor.RED);
		board.setElement(3, 2, TokenColor.RED);
		board.setElement(2, 1, TokenColor.RED);
		board.setElement(1, 0, TokenColor.RED);

		assertTrue(winCondition(board));

	}

	private boolean winCondition(Board board) {
		if (rules.checkHorizontal(board, WIN_CONDITION) ||
			rules.checkVertical(board, WIN_CONDITION) ||
			rules.checkDiagonal(board, WIN_CONDITION))
			return true;
		
		return false;
	}
	
}
