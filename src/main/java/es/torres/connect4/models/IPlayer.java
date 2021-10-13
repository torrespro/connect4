package es.torres.connect4.models;

import es.torres.connect4.types.TokenColor;

/*
 * Methods that are common for both AI and human players. 
 */

public interface IPlayer {

	/*
	 * Return the color of the players tokens.
	 */
	TokenColor getColor();

	/*
	 * Gets players input.
	 * Only legal input is an int between 1 and board width.
	 */
	public int getPlayerInput(int width) throws IllegalArgumentException;

}
