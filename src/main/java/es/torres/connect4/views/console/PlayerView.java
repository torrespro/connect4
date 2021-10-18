package es.torres.connect4.views.console;

import es.torres.connect4.controllers.PlayController;

public class PlayerView {

    protected PlayController playController;

    PlayerView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        this.dropToken();
    }

    private void dropToken() {
        boolean ok = false;
        do {
            try {
                int targetColumn = getPlayerInput();
                if (!this.playController.isColumnFull(targetColumn)) {
                    this.playController.dropToken(targetColumn);
                    ok = true;
                }
                else {
                    Console console = Console.getInstance();
                    console.writeln( "No more space in the column, please try again");
                }
            } catch (IllegalArgumentException e) {
                Console console = Console.getInstance();
                console.writeln(e.getMessage());
            }
        } while (!ok);
    }

    /*
     * Gets players input.
     * Only legal input is an int between 1 and board width.
     */
    public int getPlayerInput() throws IllegalArgumentException {
        return this.playController.getPlayerInput(this.playController.getWidth());
    }

}
