package es.torres.connect4.views.console;

import es.torres.connect4.controllers.PlayController;

class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().write(playController);
        } while (!playController.hasWinner() && !playController.isFull());
        winMessage(playController);
        playController.nextState();
    }

    public void winMessage(PlayController playController) {
        if (playController.isFull()){
            Console.getInstance().writeln("Board is full, no winner this time, try again!");
        }
        else {
            Console.getInstance().writeln(String.format("%s (%c) won! %n", playController.getActiveColor(), playController.getActiveColor().getSymbol()));
        }
    }
}
