package connect4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import connect4.exception.IllegalMoveException;
import org.junit.jupiter.api.Test;

/*
 * Tests for Board class. 
 * Rules class is also tested here.
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
		
		board.setElement(4, 3, new Token(TokenColor.RED));
		board.setElement(3, 2, new Token(TokenColor.RED));
		board.setElement(2, 1, new Token(TokenColor.RED));
		board.setElement(1, 0, new Token(TokenColor.RED));
		
		System.out.println(board);
		
		board.dropToken(1, new Token(TokenColor.YELLOW));
		board.dropToken(3, new Token(TokenColor.YELLOW));
		board.dropToken(1, new Token(TokenColor.YELLOW));
		board.dropToken(5, new Token(TokenColor.YELLOW));
		
		System.out.println(board);
	}
	
	@Test
	public void dropToken() throws IllegalMoveException {
		board.dropToken(1, new Token(TokenColor.YELLOW));
		board.dropToken(1, new Token(TokenColor.YELLOW));
		board.dropToken(1, new Token(TokenColor.YELLOW));
		board.dropToken(1, new Token(TokenColor.YELLOW));
		
		for (int i = 4; i < 0; i--) {
			Token tk = ((Token) board.getElement(0, i));
			assertEquals(tk.getColor(), TokenColor.YELLOW);
		}
		
		board.dropToken(2, new Token(TokenColor.YELLOW));
		board.dropToken(3, new Token(TokenColor.YELLOW));
		board.dropToken(4, new Token(TokenColor.YELLOW));
		board.dropToken(5, new Token(TokenColor.YELLOW));
		
		for (int i = 0; i < 4; i++) {
			Token tk = ((Token) board.getElement(i, 4));
			assertEquals(tk.getColor(), TokenColor.YELLOW);
		}
	}
	
	

}
