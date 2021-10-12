package es.torres.connect4.views.console;


import es.torres.connect4.controllers.StartController;

public class StartView {

    void interact(StartController startController) {
//        Message.TITLE.writeln();
        new BoardView().write(startController);
        startController.nextState();
    }

}
