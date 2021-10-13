package es.torres.connect4.controllers;

import es.torres.connect4.exception.IllegalMoveException;

public interface ControllersVisitor {

    void visit(StartController startController);
	void visit(PlayController playController) throws IllegalMoveException;

}
