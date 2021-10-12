package es.torres.connect4.views;

import es.torres.connect4.controllers.PlayController;
import es.torres.connect4.controllers.StartController;
import es.torres.connect4.exception.IllegalMoveException;

public interface View {//extends ControllersVisitor {

    void start(StartController startController);
    void play(PlayController playController) throws IllegalMoveException;

}
