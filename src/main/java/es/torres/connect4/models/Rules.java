package es.torres.connect4.models;

import es.torres.connect4.types.TokenColor;

/*
 * The class that decides if a Board has a winning combination on it.
 * It receives an int that decides how many tokens in a row is needed to win.
 * Rules is generic so that it's easier to use in other peoples games as well.
 *
 * Class is divided into methods that check up, down and diagonally. They are similar in nature.
 */
public class Rules<T> {

    private int winCondition;
    int winLength; // How much space is needed to check to find a winning combination.

    public Rules(int winCondition) {
        if (winCondition > 1) {
            this.winCondition = winCondition;
        } else {
            this.winCondition = 2;    //We need at least two tokens in a row to win...
        }

        this.winLength = winCondition - 1;
    }

    public <T> boolean checkHorizontal(Board board, int winCondition) {
        int WIDTH = board.getWidth();
        int HEIGHT = board.getHeight();

        for (int row = 0; row < HEIGHT; row++) { // iterate rows, top to bottom
            for (int column = 0; column < WIDTH; column++) { // iterate columns, left to right
                if (board.getElement(column, row) != null) { // Checks if current place on grid is null
                    T token = (T) board.getElement(column, row);
                    if (column + winLength < WIDTH) { // If there is no room for a winning combination, continue.
                        int counter = 1; // We already have the first token, we need to find three more.
                        for (int i = column + 1; i < WIDTH; i++) {
                            //if empty we stop
                            if (board.getElement(i, row) == null) {
                                break;
                            }
                            //if same color
                            if (token.equals(board.getElement(i, row))) {
                                counter++;
                            } else {
                                break;
                            }

                            if (counter == winCondition) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public <T> boolean checkVertical(Board board, int winCondition) {
        int WIDTH = board.getWidth();
        int HEIGHT = board.getHeight();

        for (int row = 0; row < HEIGHT; row++) { // iterate rows, top to bottom.
            for (int column = 0; column < WIDTH; column++) { // iterate columns, left to right
                if (board.getElement(column, row) != null) {
                    T token = (T) board.getElement(column, row);

                    if (row + winLength < HEIGHT) {
                        int counter = 1;
                        for (int i = row + 1; i < HEIGHT; i++) {
                            if (board.getElement(column, i) == null) {
                                counter = 1;
                                break;
                            }
                            if (token.equals(board.getElement(column, i))) {
                                counter++;
                            } else {
                                break;
                            }
                            if (counter == winCondition) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public <T> boolean checkDiagonal(Board board, int winCondition) {
        int WIDTH = board.getWidth();
        int HEIGHT = board.getHeight();

        for (int row = 0; row < HEIGHT; row++) { // iterate rows, top to bottom
            for (int column = 0; column < WIDTH; column++) { // iterate columns, left to right
                if (board.getElement(column, row) != null) {
                    T token = ((T) board.getElement(column, row));
                    if (column + winLength < WIDTH && row - winLength >= 0) { // Check up and to the right
                        int counter = 1;
                        for (int i = 1; i < HEIGHT; i++) {
                            try {
                                if (board.getElement(column + i, row - i) == null) { //Not a matching token. Break.
                                    counter = 1;
                                    break;
                                }
                                if (token.equals(board.getElement(column + i, row - i))) {
                                    counter++; //Counts the number of matching tokens in a row
                                } else {
                                    break;
                                }
                                if (counter == winCondition) {
                                    return true;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                    }

                    if (column - winLength >= 0 && row - winLength >= 0) { // Check up and to the left
                        int counter = 1;
                        for (int i = 1; i < WIDTH; i++) {
                            try {
                                if (board.getElement(column - i, row - i) == null) {
                                    counter = 1;
                                    break;
                                }
                                if (token.equals(board.getElement(column - i, row - i))) {
                                    counter++;
                                } else {
                                    break;
                                }
                                if (counter == winCondition) {
                                    return true;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean areFourConnected(Board board, TokenColor player) {

        int WIDTH = board.getWidth();
        int HEIGHT = board.getHeight();

        // horizontalCheck
        for (int j = 0; j < HEIGHT - 3; j++) {
            for (int i = 0; i < WIDTH; i++) {
                if (player.equals(board.getElement(i, j))
                    && player.equals(board.getElement(i, j + 1))
                    && player.equals(board.getElement(i, j + 2))
                    && player.equals(board.getElement(i, j + 3))) {
                    return true;
                }
            }
        }
        // verticalCheck
        for (int i = 0; i < WIDTH - 3; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (player.equals(board.getElement(i, j))
                    && player.equals(board.getElement(i + 1, j))
                    && player.equals(board.getElement(i + 2, j))
                    && player.equals(board.getElement(i + 3, j))) {
                    return true;
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i = 3; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT - 3; j++) {
                if (player.equals(board.getElement(i, j))
                    && player.equals(board.getElement(i - 1, j + 1))
                    && player.equals(board.getElement(i - 2, j + 2))
                    && player.equals(board.getElement(i - 3, j + 3))) {
                    return true;
                }
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < WIDTH; i++) {
            for (int j = 3; j < HEIGHT; j++) {
                if (player.equals(board.getElement(i, j))
                    && player.equals(board.getElement(i - 1, j + 1))
                    && player.equals(board.getElement(i - 2, j + 2))
                    && player.equals(board.getElement(i - 3, j + 3))) {
                    return true;
                }
            }
        }
        return false;
    }

}
