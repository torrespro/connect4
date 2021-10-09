package connect4.models;

import connect4.exception.IllegalMoveException;
import connect4.types.TokenColor;

public class Player implements IPlayer {

    private TokenColor color;
    private String name;

    public Player(TokenColor color, String name) {
        this.color = color;
        this.name = name;
    }

    //Returns true when a token has been dropped in target column in Board.
//    public boolean move(Board board) throws IllegalMoveException {
//        try {
//            int targetColumn = getPlayerInput(board);
//            return board.dropToken(targetColumn, color);
//        } catch (IllegalArgumentException | IndexOutOfBoundsException | InputMismatchException e) {
//            throw new IllegalMoveException("Try again! Please enter a number between 1 - " + board.getWidth());
//        }
//    }
//
//    /*
//     * Gets players input.
//     * Only legal input is an int between 1 and board width.
//     */
//    public static int getPlayerInput(Board board) throws IllegalArgumentException {
//        System.out.println("What column would you like to drop the token into?");
//        Scanner in = new Scanner(System.in);
//        int input = in.nextInt();
//        if (input > board.getWidth() || input < 1) {
//            throw new IllegalArgumentException();
//        }
//        System.out.println();
//        return input;
//    }

    @Override
    public boolean move(Board board) throws IllegalMoveException {
        return false;
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
}
