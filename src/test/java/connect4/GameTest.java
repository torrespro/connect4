package connect4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import connect4.exception.IllegalMoveException;
import connect4.rules.Rules;
import org.junit.jupiter.api.Test;

public class GameTest {
	private Game game = new Game(0, 7, 6);
	Board board = game.getBoard();
	final int WIN_CONDITION = 4;
	Rules rules = game.getRules();

	 @Test
	public void hasWonTest() throws IllegalMoveException {
		game.startGame();

		assertTrue(game.isFinished());
	}

	@Test
	public void insertTokenTest() {

		for (int i = 0; i < board.getHeight(); i++) {
			board.setElement(0, i, new Token(TokenColor.RED));

		}

		for (int i = 0; i < board.getHeight(); i++) {
			TokenColor tc = ((Token) board.getElement(0, i)).getColor();
			assertEquals(tc, TokenColor.RED);
		}

	}

	@Test
	public void horizontalWin() {
		board.initializeBoard();
		Rules rules = new Rules(this.game, 4);

		// board2.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(3, 4, new Token(TokenColor.RED));
		board.setElement(2, 4, new Token(TokenColor.RED));
		board.setElement(1, 4, new Token(TokenColor.RED));
		board.setElement(0, 4, new Token(TokenColor.RED));

		assertTrue(winCondition(board));
		assertTrue(rules.checkHorizontal(board, 4));
	}

	@Test
	public void verticalTest() {
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(4, 3, new Token(TokenColor.RED));
		board.setElement(4, 2, new Token(TokenColor.RED));
		board.setElement(4, 1, new Token(TokenColor.RED));

		assertTrue(winCondition(board));
	}
	
	@Test
	public void diagonalTest() {
	
		board.setElement(0, 4, new Token(TokenColor.RED));
		board.setElement(1, 3, new Token(TokenColor.RED));
		board.setElement(2, 2, new Token(TokenColor.RED));
		board.setElement(3, 1, new Token(TokenColor.RED));

		assertTrue(winCondition(board));
		board.clearBoard();
		
		board.setElement(4, 4, new Token(TokenColor.RED));
		board.setElement(3, 3, new Token(TokenColor.RED));
		board.setElement(2, 2, new Token(TokenColor.RED));
		board.setElement(1, 1, new Token(TokenColor.RED));

		assertTrue(winCondition(board));
		board.clearBoard();
		
		board.setElement(4, 3, new Token(TokenColor.RED));
		board.setElement(3, 2, new Token(TokenColor.RED));
		board.setElement(2, 1, new Token(TokenColor.RED));
		board.setElement(1, 0, new Token(TokenColor.RED));

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
