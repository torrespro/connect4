package connect4.models;

import connect4.exception.IllegalMoveException;
import connect4.types.TokenColor;

/*
 * Methods that are common for both AI and human players. 
 */

public interface IPlayer {
	
	/*
	 * <p>
	 * Do a turn. Drop a token in a column on the board.
	 * Drop token in the Board. Return true when dropped. 
	 * </p>
	 *
	 * @param board
	 */
	 boolean move(Board board) throws IllegalMoveException;
	 
	 /*
	  * Return the color of the players tokens.
	  */
	 TokenColor getColor();
	 
	 
	

}
