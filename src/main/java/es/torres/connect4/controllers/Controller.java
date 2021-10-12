package es.torres.connect4.controllers;

import es.torres.connect4.models.Game;
import es.torres.connect4.models.State;
import es.torres.connect4.types.TokenColor;

public abstract class Controller {

    protected Game game;
    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }


    public void nextState() {
        this.state.next();
    }

    public int getHeight() {
        return this.game.getBoard().getHeight();
    }

    public int getWidth() {
        return this.game.getBoard().getWidth();
    }

    public Object getCell(int index) {
        return this.game.getBoard().getCells().get(index);
    }

    public char getCellSymbol(int index) {
        return ((TokenColor) (game.getBoard().getCells()).get(index)).getSymbol();
    }

}
