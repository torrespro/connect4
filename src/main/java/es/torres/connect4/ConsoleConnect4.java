package es.torres.connect4;

import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.views.console.ConsoleView;
import java.io.IOException;

class ConsoleConnect4 extends Connect4 {


    public ConsoleConnect4() {
    }

    @Override
    protected ConsoleView createView() {
        return new ConsoleView();
    }

    public static void main(String[] args) throws IOException, IllegalMoveException {
        new ConsoleConnect4().play();
    }

}
