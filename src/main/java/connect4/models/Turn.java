package connect4.models;

public class Turn {

    private IPlayer player;

    public Turn(IPlayer player) {
        this.player = player;
    }

    public IPlayer getPlayer() {
        return player;
    }

    public void setPlayer(IPlayer player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return player.getColor() + "'s turn!";
    }
}
