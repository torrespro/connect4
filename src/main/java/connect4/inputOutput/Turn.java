package connect4.inputOutput;

import connect4.Board;
import connect4.players.IPlayer;

public class Turn {

    private IPlayer player;

    public Turn(IPlayer player) {
        this.player = player;
    }

    public static void playersTurn(IPlayer player) {
        System.out.println(player.getColor() + "'s turn!");
    }


    public static void winMessage(IPlayer winner, Board board) {
        System.out.printf("%s won! %n", winner.getColor());
        System.out.println(board);
    }

    public static void illegalMove(Board board) {
        System.out.println("Out of bounds! Please enter a number between 1 - " + board.getWidth());
    }

    public IPlayer getPlayer() {
        return player;
    }

    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Turn{" +
            "player=" + player +
            '}';
    }
}
