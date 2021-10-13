package es.torres.connect4;

import es.torres.connect4.controllers.Controller;
import es.torres.connect4.controllers.Logic;
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
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                controller.accept(this.view);
        } while (controller != null);
    }

}
