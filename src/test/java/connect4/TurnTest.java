package connect4;

import connect4.inputOutput.Turn;
import connect4.players.IPlayer;
import connect4.players.Player;

public class TurnTest {

    IPlayer player = new Player(TokenColor.RED, "Player1");
    Board board = new Board(5, 5);
    Turn turn = new Turn(player);

//    @Test
//    public void doTurnTestPlayer() {
//
//        //Give input from 1 - 5 to see that returns true for the right input
//        System.out.println("Enter the right input! A number from 1 - 5!");
//        InputStream sysInBackup = System.in; // backup System.in to restore it later
//        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
//        System.setIn(in);
//
//        assertEquals(turn.getPlayerInput(board));
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
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            turn.getPlayerInput(board);
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
//        Assertions.assertThrows(InputMismatchException.class, () -> {
//            turn.getPlayerInput(board);
//        });
//
//        System.setIn(sysInBackup);
//    }


}
