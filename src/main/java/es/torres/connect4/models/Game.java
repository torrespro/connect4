package es.torres.connect4.models;

import es.torres.connect4.exception.IllegalMoveException;
import es.torres.connect4.types.TokenColor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Game {

    private final int WIN_CONDITION = 4; //How many tokens of the same color is needed to win.
    private Board board;
    public static final int NUM_PLAYERS = 2;
    private ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    private int activePlayer;

    public Game() {
        InputStream input = Game.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        if (input == null) {
            System.out.println("Sorry, unable to find config.properties");
            return;
        }
        Integer gameMode;
        Integer width;
        Integer height;
        //load a properties file from class path, inside static method
        try {
            prop.load(input);
            gameMode = Integer.parseInt(prop.getProperty("game.mode"));
            width = Integer.parseInt(prop.getProperty("game.width"));
            height = Integer.parseInt(prop.getProperty("game.height"));
        } catch (IOException e) {
            System.out.println("Missing config, using default values");
            gameMode = 0;
            width = 7;
            height = 6;
        }

        board = new Board(width, height);
        this.activePlayer = 0;

        switch (gameMode) {
            case 0: { // Two human players
                for (int i = 0; i < NUM_PLAYERS; i++) {
                    players.add(new HumanPlayer(TokenColor.values()[i], "Player" + i));
                }
                break;
            }
            case 1: { // One human, one AI
                players.add(new HumanPlayer(TokenColor.RED, "Player1"));
                players.add(new AIPlayer(TokenColor.YELLOW));
                break;
            }
            case 2: { // Two AIs
                for (int i = 0; i < NUM_PLAYERS; i++) {
                    players.add(new AIPlayer(TokenColor.values()[i]));
                }
            }
        }

        board.initializeBoard();

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

    public int getActivePlayer() {
        return activePlayer;
    }

    public TokenColor getActiveColor() {
        return this.players.get(activePlayer).getColor();
    }

    public void setActivePlayer(int activePlayer) {
        this.activePlayer = activePlayer;
    }

    public boolean hasWinner() {
        return this.board.hasWinner();
    }

    public void next() {
        if (!this.hasWinner()) {
            this.activePlayer = (this.activePlayer + 1) % NUM_PLAYERS;
        }
    }

    public void dropToken(int targetColumn) throws IllegalMoveException {
        board.dropToken(targetColumn, getPlayers().get(getActivePlayer()).getColor());
    }

    public boolean isFull() {
        return this.board.isFull();
    }
}
