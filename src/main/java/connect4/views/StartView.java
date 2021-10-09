package connect4.views;


import connect4.models.Game;

class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
//        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }

}
