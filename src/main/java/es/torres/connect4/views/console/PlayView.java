package es.torres.connect4.views.console;

import es.torres.connect4.controllers.PlayController;
import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.types.TokenColor;

class PlayView {

    void interact(PlayController playController) throws IllegalMoveException {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().write(playController);
        } while (!playController.hasWon() || !playController.isFull());
        winMessage(playController.getActiveColor());
        playController.nextState();
    }

    public void winMessage(TokenColor winner) {
        System.out.printf("%s (%c) won! %n", winner, winner.getSymbol());
    }
}
