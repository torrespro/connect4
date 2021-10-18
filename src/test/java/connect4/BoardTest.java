package connect4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.models.Board;
import es.torres.connect4.models.Coordinate;
import es.torres.connect4.types.TokenColor;
import org.junit.jupiter.api.Test;

/*
 * Tests for Board class. 
 */
public class BoardTest {
	Board board = new Board(5,5);

	@Test
	public <T> void boardSize() {
		for (int i = 1; i < 10; i++) {
			Board board = new Board(i, i);
			assertEquals(i, board.getWidth());
		}

	}


	@Test
	public void initializeBoard() {
		int width = 5;
		int height = 5;
		
		Board board2 = new Board(width, height);
		
		board2.initializeBoard();
		
		for (int i = 0; i < (width * height); i++) {
			assertEquals(board2.getCells().get(i), null);
		}
	}
	
	@Test
	public void printBoardTest() throws IllegalMoveException {
		
		board.setElement(4, 3, TokenColor.RED);
		board.setElement(3, 2, TokenColor.RED);
		board.setElement(2, 1, TokenColor.RED);
		board.setElement(1, 0, TokenColor.RED);
		
		System.out.println(board);
		
		board.dropToken(1, TokenColor.YELLOW);
		board.dropToken(3, TokenColor.YELLOW);
		board.dropToken(1, TokenColor.YELLOW);
		board.dropToken(5, TokenColor.YELLOW);
		
		System.out.println(board);
	}
	
	@Test
	public void dropToken() throws IllegalMoveException {
		board.dropToken(1, TokenColor.YELLOW);
		board.dropToken(1, TokenColor.YELLOW);
		board.dropToken(1, TokenColor.YELLOW);
		board.dropToken(1, TokenColor.YELLOW);

		for (int i = 4; i < 0; i--) {
			TokenColor tk = ((TokenColor) board.getElement(0, i));
			assertEquals(tk, TokenColor.YELLOW);
		}

		board.dropToken(2, TokenColor.YELLOW);
		board.dropToken(3, TokenColor.YELLOW);
		board.dropToken(4, TokenColor.YELLOW);
		board.dropToken(5, TokenColor.YELLOW);

		for (int i = 0; i < 4; i++) {
			TokenColor tk = ((TokenColor) board.getElement(i, 4));
			assertEquals(tk, TokenColor.YELLOW);
		}
	}

	@Test
	public void horizontalWin() {

		for (int i = 0; i < 4; i++) {
			board.setElement(i, 4, TokenColor.RED);
			board.checkWinner(new Coordinate(4, i));
		}

		assertTrue(this.board.hasWinner());
	}

	@Test
	public void verticalTest() {

		for (int i = 1; i < 5; i++) {
			board.setElement(4, i, TokenColor.RED);
			board.checkWinner(new Coordinate(i, 4));
		}

		assertTrue(this.board.hasWinner());
	}

	@Test
	public void diagonalTest() {

		board.setElement(0, 4, TokenColor.RED);
		board.setElement(1, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.setElement(3, 1, TokenColor.RED);
		board.checkWinner(new Coordinate( 1, 3));

		assertTrue(this.board.hasWinner());
		board.clearBoard();

		board.setElement(4, 4, TokenColor.RED);
		board.setElement(3, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.setElement(1, 1, TokenColor.RED);
		board.checkWinner(new Coordinate(1, 1));

		assertTrue(this.board.hasWinner());
		board.clearBoard();

		board.setElement(4, 3, TokenColor.RED);
		board.setElement(3, 2, TokenColor.RED);
		board.setElement(2, 1, TokenColor.RED);
		board.setElement(1, 0, TokenColor.RED);
		board.checkWinner(new Coordinate(0, 1));

		assertTrue(this.board.hasWinner());
		board.clearBoard();


		//Three in a row, should return false.
		board.setElement(4, 4, TokenColor.RED);
		board.setElement(3, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.checkWinner(new Coordinate(2, 2));

		assertFalse(this.board.hasWinner());
		board.clearBoard();


		//Three in a row, should return false
		board.setElement(0, 4, TokenColor.RED);
		board.setElement(1, 3, TokenColor.RED);
		board.setElement(2, 2, TokenColor.RED);
		board.checkWinner(new Coordinate(2, 2));

		assertFalse(this.board.hasWinner());
		board.clearBoard();

	}
	
	

}
