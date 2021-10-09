package connect4;

import connect4.models.Game;
import connect4.views.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Connect4 {

    private Game game;
    private View view;

    public Connect4() throws IOException {
        InputStream input = Connect4.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        if (input == null) {
            System.out.println("Sorry, unable to find config.properties");
            return;
        }
        //load a properties file from class path, inside static method
        prop.load(input);

        Integer gameMode = Integer.parseInt(prop.getProperty("game.mode"));
        Integer width = Integer.parseInt(prop.getProperty("game.width"));
        Integer height = Integer.parseInt(prop.getProperty("game.height"));

        this.game = new Game(gameMode, width, height);
        ;
        this.view = new View(game);
    }

    private void play() {
        this.view.start();
        this.view.play();
    }

    public static void main(String[] args) throws IOException {
        new Connect4().play();
    }

}
