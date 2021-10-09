package connect4.models;

import connect4.exception.IllegalMoveException;
import connect4.types.TokenColor;
import java.util.Random;

public class AIPlayer implements IPlayer {

    private TokenColor color;
    private String name;

    public AIPlayer(TokenColor color) {
        this.color = color;
        this.name = name;
    }

    /*
     * Very stupid AI. Picks a random number between 1 and board width.
     * In the future I can hopefully upgrade this to return a smart move.
     */
    @Override
    public boolean move(Board board) throws IllegalMoveException {
        Random random = new Random();
        boolean dropped = false;

        while (!dropped) {
            int targetColumn = random.nextInt(board.getWidth() + 1);

            if (targetColumn > 0 && targetColumn <= board.getWidth()) {
                dropped = board.dropToken(targetColumn, color);
            }
        }
        return dropped;
    }

    @Override
    public TokenColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

}
