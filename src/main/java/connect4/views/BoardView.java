package connect4.views;

import connect4.Console;
import connect4.models.Game;
import connect4.types.TokenColor;

public class BoardView {

    void write(Game game) {
        StringBuffer boardBuffer = new StringBuffer();
        int index = 0;
        for (int j = 0; j < game.getBoard().getHeight(); j++) {
            for (int i = 0; i < game.getBoard().getWidth(); i++) {
                if (game.getBoard().getCells().get(index) != null) {
                    boardBuffer.append("| " + ((TokenColor) (game.getBoard().getCells()).get(index)).getSymbol() + " ");
                } else {
                    boardBuffer.append("|   ");
                }
                index++;
            }
            boardBuffer.append("|\n");
        }

        for (int i = 0; i < game.getBoard().getWidth(); i++) {
            boardBuffer.append("  " + (i + 1) + " ");
        }
        boardBuffer.append("\n");
        Console.getInstance().write(boardBuffer.toString());
    }

}
