package connect4.models;

import connect4.types.TokenColor;
import java.util.ArrayList;

public class Game {

    private final int WIN_CONDITION = 4; //How many tokens of the same color is needed to win.
    private Board board;
    private ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    private int activePlayer;

    private Rules rules;

    public Game(int mode, int width, int height) {
        board = new Board(width, height);
        rules = new Rules(WIN_CONDITION);

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

//    public <T> Board<T> getBoard() {
//        return board;
//    }

//    public void startGame() {
//        int turno = 0;
//        int turnoPrev;
//        do {
//            boolean dropped = false;
//            System.out.println(board); // Prints the board on the screen.
//            IPlayer player = players.get(turno);
//            Turn turn = new Turn(player);
//            System.out.println(turn); // Announces a players turn
//            do {
//                try {
//                    dropped = player.move(board);
//                } catch (IllegalMoveException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//            while (!dropped);
//            turnoPrev = turno;
//            turno = (turno+1) % 2;
//        } while (!rules.hasWon(board));
//        winMessage(players.get(turnoPrev), board);
//    }

    // For debugging
    public Rules getRules() {
        return rules;
    }

    public int getWIN_CONDITION() {
        return WIN_CONDITION;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<IPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<IPlayer> players) {
        this.players = players;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public static void winMessage(IPlayer winner, Board board) {
        System.out.printf("%s won! %n", winner.getColor());
        System.out.println(board);
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    public boolean hasWon() {
        if (this.rules.checkHorizontal(this.board, WIN_CONDITION) ||
            this.rules.checkVertical(this.board, WIN_CONDITION) ||
            this.rules.checkDiagonal(this.board, WIN_CONDITION)) {
            return true;
        }
        return false;
    }
}
