package es.torres.connect4.views.console;

import es.torres.connect4.controllers.PlayController;
import es.torres.connect4.controllers.StartController;
import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.views.View;

public class ConsoleView implements View {

    private StartView startView;
    private PlayView playView;

    public ConsoleView() {
        this.startView = new StartView();
        this.playView = new PlayView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void visit(PlayController playController) throws IllegalMoveException {
        this.playView.interact(playController);
    }
}
