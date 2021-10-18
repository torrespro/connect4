package es.torres.connect4.models;

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

    public void dropToken(int column, T token) {
        column--;

        for (int i = super.getHeight() - 1; i >= 0; i--) {
            Coordinate coordinate = new Coordinate(i, column);
            if (getElement(coordinate) == null) {
                setElement(coordinate, token); // Puts the token in the correct x,y position.
                checkWinner(coordinate);
                return;
            }
        }
//        throw new IllegalMoveException("No more space in the column, please try again");
    }

    public void checkWinner(Coordinate coordinate) {
        // check all values of enum Direction for a winner
        // so HORIZONTAL, VERTICAL, etc
        int enumIndex = 0;
        while (!hasWinner && enumIndex < Direction.values().length) {
            hasWinner = check(coordinate, POSITIVE, Direction.values()[enumIndex])
                + check(coordinate, NEGATIVE, Direction.values()[enumIndex]) == 3;
            enumIndex++;
        }
    }

    private int check(Coordinate coordinate, int direction, Direction type) {
        int row = coordinate.row;
        int col = coordinate.column;
        TokenColor color = (TokenColor) getElement(coordinate);
        row += type.row * direction;
        col += type.col * direction;
        Coordinate coordinate_next = new Coordinate(row, col);
        if (row >= this.getHeight() || row < 0 || col >= this.getWidth() || col < 0 || !color.equals(this.getElement(coordinate_next))) {
            return 0;
        } else {
            return 1 + check(coordinate_next, direction, type);
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
