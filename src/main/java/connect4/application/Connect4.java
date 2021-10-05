package connect4.application;

import connect4.Game;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Connect4 {

	public static void main(String[] args) {
		try (InputStream input = Connect4.class.getClassLoader().getResourceAsStream("config.properties")) {
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

			Game game = new Game(gameMode, width, height);
			game.startGame();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
