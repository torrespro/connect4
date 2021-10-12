package es.torres.connect4.controllers;

import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.models.Game;
import es.torres.connect4.models.State;
import es.torres.connect4.types.TokenColor;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

//    @Override
//    public void accept(ControllersVisitor controllersVisitor) {
//        controllersVisitor.visit(this);
//    }

    public boolean hasWon() {
        return this.game.hasWon2();
    }

    public void next() {
        this.game.next();
    }

    public TokenColor getActiveColor() {
        return this.game.getActiveColor();
    }

    public void dropToken(int targetColumn) throws IllegalMoveException {
        this.game.dropToken(targetColumn);
    }

}
