package es.torres.connect4.models;

import es.torres.connect4.types.TokenColor;
import es.torres.connect4.views.console.Console;

public class HumanPlayer implements IPlayer {

    private TokenColor color;
    private String name;

    public HumanPlayer(TokenColor color, String name) {
        this.color = color;
        this.name = name;
    }

    @Override
    public TokenColor getColor() {
        return color;
    }

    public void setColor(TokenColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Gets players input.
     * Only legal input is an int between 1 and board width.
     */
    public int getPlayerInput(int width) throws IllegalArgumentException {
        Console console = Console.getInstance();
        int input = console.readInt("What column would you like to drop the token into?\n");
        if (input > width || input < 1) {
            throw new IllegalArgumentException(String.format("Please use a number between 1 and %d", width));
        }
        return input;
    }
}
