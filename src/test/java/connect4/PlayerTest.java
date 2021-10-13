package connect4;

import es.torres.connect4.models.Board;
import es.torres.connect4.models.HumanPlayer;
import es.torres.connect4.models.IPlayer;
import es.torres.connect4.types.TokenColor;

public class PlayerTest {

    IPlayer player = new HumanPlayer(TokenColor.RED, "Player1");
    Board board = new Board(5, 5);

//    @Test
//    public void doTurnTestPlayer() throws IllegalMoveException {
//
//        //Give input from 1 - 5 to see that returns true for the right input
//        System.out.println("Enter the right input! A number from 1 - 5!");
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
//        System.setIn(in);
//
//        assertTrue(player.move(board));
//
//        System.setIn(sysInBackup);
//
//    }
//
//    @Test
//    public void doFailTurnTestPlayer() {
//
//        System.out.println("Enter wrong input! Either the wrong number or a String!");
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
//        System.setIn(in);
//
//        Assertions.assertThrows(IllegalMoveException.class, () -> {
//            player.move(board);
//        });
//
//        System.setIn(sysInBackup);
//    }
//
//    @Test
//    public void doFailStringTurnTestPlayer() {
//
//        System.out.println("Enter wrong input! Either the wrong number or a String!");
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("hola".getBytes());
//        System.setIn(in);
//
//        Assertions.assertThrows(IllegalMoveException.class, () -> {
//            player.move(board);
//        });
//
//        System.setIn(sysInBackup);
//    }


}
