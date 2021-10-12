package es.torres.connect4;

import es.torres.connect4.controllers.Logic;
import es.torres.connect4.controllers.PlayController;
import es.torres.connect4.controllers.StartController;
import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.views.View;

public abstract class Connect4 {

    private Logic logic;
    private View view;

    public Connect4() {
        this.logic = new Logic();
        this.view = this.createView();
    }

    protected abstract View createView();

    protected void play() throws IllegalMoveException {
        do {
            if (logic.getController() instanceof StartController) {
                this.view.start((StartController) logic.getController());
            } else {
                if (logic.getController() instanceof PlayController) {
                    this.view.play((PlayController) logic.getController());
                }
            }
        } while (logic.getController() != null);
    }

}
