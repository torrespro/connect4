package es.torres.connect4.views.console;

import es.torres.connect4.controllers.Controller;

public class BoardView {

    void write(Controller controller) {
        StringBuffer boardBuffer = new StringBuffer();
        int index = 0;
        for (int j = 0; j < controller.getHeight(); j++) {
            for (int i = 0; i < controller.getWidth(); i++) {
                if (controller.getCell(index) != null) {
                    boardBuffer.append("| " + (controller.getCellSymbol(index))+ " ");
                } else {
                    boardBuffer.append("|   ");
                }
                index++;
            }
            boardBuffer.append("|\n");
        }

        for (int i = 0; i < controller.getWidth(); i++) {
            boardBuffer.append("  " + (i + 1) + " ");
        }
        boardBuffer.append("\n");
        Console.getInstance().write(boardBuffer.toString());
    }

}
