package connect4.views;

import connect4.exception.IllegalMoveException;
import connect4.models.Game;
import connect4.models.IPlayer;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

//    void interact() {
//        do {
//            new PlayerView(this.game).interact();
//            this.game.next();
//            new BoardView().write(this.game);
//        } while (!this.game.isTicTacToe());
//        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
//    }


    public void interact() {
        int turnoPrev;
        do {
            try {
                new PlayerView(this.game).interact();
            } catch (IllegalMoveException e) {
                System.out.println(e.getMessage());
            }
            turnoPrev = this.game.getActivePlayer();
            this.game.setActivePlayer((this.game.getActivePlayer() + 1) % this.game.getPlayers().size());
            new BoardView().write(this.game); // Prints the board on the screen.
//            turnoPrev = turno;
//            turno = (turno + 1) % 2;
        } while (!this.game.hasWon());
        winMessage(this.game.getPlayers().get(turnoPrev));
    }

    public void winMessage(IPlayer winner) {
        System.out.printf("%s won! %n", winner.getColor());
        new BoardView().write(this.game); // Prints the board on the screen.
    }

}
