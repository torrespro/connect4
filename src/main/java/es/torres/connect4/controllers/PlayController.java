package es.torres.connect4.controllers;

import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.models.Coordinate;
import es.torres.connect4.models.Game;
import es.torres.connect4.models.IPlayer;
import es.torres.connect4.models.State;
import es.torres.connect4.types.TokenColor;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) throws IllegalMoveException {
        controllersVisitor.visit(this);
    }

    public boolean hasWinner() {
        return this.game.hasWinner();
    }

    public void next() {
        this.game.next();
    }

    public TokenColor getActiveColor() {
        return this.game.getActiveColor();
    }

    public void dropToken(int targetColumn) {
        this.game.dropToken(targetColumn);
    }

    public boolean isFull() {
        return this.game.isFull();
    }

    public IPlayer getActivePlayer() {
        return this.game.getPlayers().get(this.game.getActivePlayer());
    }

    public int getPlayerInput(int width) {
        IPlayer player = this.game.getPlayers().get(this.game.getActivePlayer());
        return player.getPlayerInput(width);
    }

    public boolean isColumnFull(int targetColumn) {
        targetColumn--;
        boolean isColumnFull = true;
        for (int i = super.getHeight() - 1; i >= 0; i--) {
            Coordinate coordinate = new Coordinate(i, targetColumn);
            if (this.game.getBoard().getElement(coordinate) == null) {
                isColumnFull = false;
            }
        }
        return isColumnFull;
    }
}
