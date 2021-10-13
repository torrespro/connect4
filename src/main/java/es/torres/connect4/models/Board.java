package es.torres.connect4.models;

import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.types.Direction;
import es.torres.connect4.types.TokenColor;

public class Board<T> extends Grid<T> {

    private boolean hasWinner = false;
    private static final int POSITIVE = 1;
    private static final int NEGATIVE = -1;

    public boolean hasWinner() {
        return hasWinner;
    }

    // Creates a new game board with the given dimensions.
    public Board(int width, int height) {
        super(width, height);
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < getHeight() * getWidth(); ++i) {
            cells.add(null);
        }
        this.hasWinner = false;
    }

    public void clearBoard() {
        for (int i = 0; i < cells.size(); i++) {
            cells.set(i, null);
        }
        this.hasWinner = false;
    }

    public boolean isFull() {
        return !cells.contains(null);
    }

    public void dropToken(int column, T token) throws IllegalMoveException {
        column--;

        for (int i = super.getHeight() - 1; i >= 0; i--) {
            if (getElement(column, i) == null) {
                setElement(column, i, token); // Puts the token in the correct x,y position.
                checkWinner((TokenColor)token, i, column);
                return;
            }
        }
        throw new IllegalMoveException("No more space in the column, please try again");

    }

    public void checkWinner(TokenColor color, int row, int col) {
        // check all values of enum Direction for a winner
        // so HORIZONTAL, VERTICAL, etc
        int enumIndex = 0;
        while (!hasWinner && enumIndex < Direction.values().length) {
            hasWinner = check(color, row, col, POSITIVE, Direction.values()[enumIndex])
                + check(color, row, col, NEGATIVE, Direction.values()[enumIndex]) == 3;
            enumIndex++;
        }
    }

    private int check(TokenColor color, int row, int col, int direction, Direction type) {
        row += type.row * direction;
        col += type.col * direction;
        if (row >= this.getHeight() || row < 0 || col >= this.getWidth() || col < 0 || !color.equals(this.getElement(col, row))) {
            return 0;
        } else {
            return 1 + check(color, row, col, direction, type);
        }
    }


    @Override
    public String toString() {
        StringBuffer board = new StringBuffer();
        int index = 0;
        for (int j = 0; j < this.getHeight(); j++) {
            for (int i = 0; i < this.getWidth(); i++) {
                if (this.getCells().get(index) != null) {
                    board.append("| " + ((TokenColor) (this.getCells()).get(index)).getSymbol() + " ");
                } else {
                    board.append("|   ");
                }
                index++;
            }
            board.append("|\n");
        }

        for (int i = 0; i < this.getWidth(); i++) {
            board.append("  " + (i + 1) + " ");
        }
        board.append("\n");

        return board.toString();
    }
}
