package es.torres.connect4.models;

import es.torres.connect4.types.TokenColor;
import es.torres.connect4.views.console.Console;
import java.util.Random;

public class AIPlayer implements IPlayer {

    private TokenColor color;
    private String name;

    public AIPlayer(TokenColor color) {
        this.color = color;
        this.name = name;
    }

    @Override
    public TokenColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    /*
     * Very stupid AI. Picks a random number between 1 and board width.
     */
    public int getPlayerInput(int width) throws IllegalArgumentException {
        Console console = Console.getInstance();
        console.writeln("What column would you like to drop the token into?");
        Random random = new Random();
        int input = random.ints(1,width + 1).findFirst().getAsInt();;
        console.writeln(input);
        return input;
    }

}
