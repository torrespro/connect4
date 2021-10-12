package es.torres.connect4.views.console;

import es.torres.connect4.controllers.PlayController;
import es.torres.connect4.exception.IllegalMoveException;
import java.util.Scanner;

class PlayerView {

    private PlayController playController;

    PlayerView(PlayController playController) {
        this.playController = playController;
    }

    void interact() throws IllegalMoveException {
        this.dropToken();
    }

    //Returns true when a token has been dropped in target column in Board.
//    public boolean move() throws IllegalMoveException {
//        try {
//            return this.playController.dropToken(targetColumn, this.game.getPlayers().get(this.game.getActivePlayer()).getColor());
//        } catch (IllegalArgumentException | IndexOutOfBoundsException | InputMismatchException e) {
//            throw new IllegalMoveException("Try again! Please enter a number between 1 - " + this.game.getBoard().getWidth());
//        }
//    }

    private void dropToken() throws IllegalMoveException {
        int targetColumn = getPlayerInput();
        this.playController.dropToken(targetColumn);
    }

    /*
     * Gets players input.
     * Only legal input is an int between 1 and board width.
     */
    public int getPlayerInput() throws IllegalArgumentException {
        System.out.println("What column would you like to drop the token into?");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        if (input > this.playController.getWidth() || input < 1) {
            throw new IllegalArgumentException();
        }
        System.out.println();
        return input;
    }

}
