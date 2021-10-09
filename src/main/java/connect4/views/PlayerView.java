package connect4.views;

import connect4.exception.IllegalMoveException;
import connect4.models.Game;
import java.util.InputMismatchException;
import java.util.Scanner;

class PlayerView {

    private Game game;

    PlayerView(Game game) {
        this.game = game;
    }

    void interact() throws IllegalMoveException {
        this.move();
    }

    //Returns true when a token has been dropped in target column in Board.
    public boolean move() throws IllegalMoveException {
        try {
            int targetColumn = getPlayerInput();
            return this.game.getBoard().dropToken(targetColumn, this.game.getPlayers().get(this.game.getActivePlayer()).getColor());
        } catch (IllegalArgumentException | IndexOutOfBoundsException | InputMismatchException e) {
            throw new IllegalMoveException("Try again! Please enter a number between 1 - " + this.game.getBoard().getWidth());
        }
    }

    /*
     * Gets players input.
     * Only legal input is an int between 1 and board width.
     */
    public int getPlayerInput() throws IllegalArgumentException {
        System.out.println("What column would you like to drop the token into?");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input > this.game.getBoard().getWidth() || input < 1) {
            throw new IllegalArgumentException();
        }
        System.out.println();
        return input;
    }

}
