package connect4.models;

import connect4.exception.IllegalMoveException;
import connect4.types.TokenColor;

public class Board<T> extends Grid<T> {

    // Creates a new game board with the given dimensions.
    public Board(int width, int height) {
        super(width, height);
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < getHeight() * getWidth(); ++i) {
            cells.add(null);
        }
    }

    public void clearBoard() {
        for (int i = 0; i < cells.size(); i++) {
            cells.set(i, null);
        }
    }


    public boolean dropToken(int column, T token) throws IllegalMoveException {
        column--;

        for (int i = super.getHeight() - 1; i >= 0; i--) {
            if (getElement(column, i) == null) {
                setElement(column, i, token); // Puts the token in the correct x,y position.
                return true;
            }
        }
        throw new IllegalMoveException("No more space in the column, please try again");
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
