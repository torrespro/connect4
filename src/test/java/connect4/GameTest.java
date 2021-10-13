package connect4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import es.torres.connect4.models.Board;
import es.torres.connect4.models.Game;
import es.torres.connect4.types.TokenColor;
import org.junit.jupiter.api.Test;

public class GameTest {
	private Game game = new Game();
	Board board = game.getBoard();

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
	
}
