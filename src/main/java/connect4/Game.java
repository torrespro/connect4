package connect4;

import connect4.exception.IllegalMoveException;
import connect4.inputOutput.Turn;
import connect4.players.AIPlayer;
import connect4.players.IPlayer;
import connect4.players.Player;
import connect4.rules.Rules;
import java.util.ArrayList;

public class Game {

    private final int WIN_CONDITION = 4; //How many tokens of the same color is needed to win.
    private Board board;
    private ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    private boolean finished = false;
    private Rules rules;

    public Game(int mode, int width, int height) {
        board = new Board(width, height);
        rules = new Rules(this, WIN_CONDITION);

        switch (mode) {
            case 0: { // Two human players
                players.add(new Player(TokenColor.RED, "Player1"));
                players.add(new Player(TokenColor.YELLOW, "Player2"));
                break;
            }
//            case 1: { // One human, one AI
//                players.add(new Player(TokenColor.RED));
//                players.add(new AIPlayer(TokenColor.YELLOW));
//                break;
//            }
            case 2: { // Two AIs
                players.add(new AIPlayer(TokenColor.RED));
                players.add(new AIPlayer(TokenColor.YELLOW));
            }
        }

        board.initializeBoard();

    }

    public <T> Board<T> getBoard() {
        return board;
    }

    public void startGame() {
//        int turn = 0;
        while (!finished) {
            boolean dropped = false;
            for (int i = 0; i < players.size(); i++) {
                System.out.println(board); // Prints the board on the screen.
                IPlayer player = players.get(i);
                Turn turn = new Turn(player);
                turn.playersTurn(player); // Announces a players turn
                do {
                    try {
                        dropped = player.move(board);
                    } catch (IllegalMoveException e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (!dropped);
                if (rules.hasWon(board)) {
                    winMessage(player, board);
                    finished = true;
                    break;
                }
            }
        }
    }

    // For debugging.
    public boolean isFinished() {
        return this.finished;
    }

    // For debugging
    public Rules getRules() {
        return rules;
    }

    public static void winMessage(IPlayer winner, Board board) {
        System.out.printf("%s won! %n", winner.getColor());
        System.out.println(board);
    }

}
