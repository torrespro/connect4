package connect4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import es.torres.connect4.models.AIPlayer;
import es.torres.connect4.models.Board;
import es.torres.connect4.models.HumanPlayer;
import es.torres.connect4.models.IPlayer;
import es.torres.connect4.types.TokenColor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    IPlayer player = new HumanPlayer(TokenColor.RED, "Player1");
    IPlayer aiplayer = new AIPlayer(TokenColor.RED);
    Board board = new Board(5, 5);

    @Test
    public void doTurnTestPlayer() {

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        assertEquals(1, player.getPlayerInput(board.getWidth()));

        System.setIn(sysInBackup);

    }

    @Test
    public void doFailTurnTestPlayer() {

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("77".getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            player.getPlayerInput(board.getWidth());
        });

        System.setIn(sysInBackup);
    }

    @Test
    public void doTurnTestAIPlayer() {

        int random = aiplayer.getPlayerInput(board.getWidth());
        assertTrue(board.getWidth() >= random);
        assertTrue(1  <= random);
    }


}
