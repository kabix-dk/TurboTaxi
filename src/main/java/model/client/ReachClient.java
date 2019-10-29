package model.client;

import model.Position;

public class ReachClient extends Client {

    private int tip;

    public ReachClient(Position position, int type) {
        super(position, type);
        this.tip = 10;
    }

    @Override
    public int getTip() {
        return tip;
    }

    @Override
    public void setTip(int tip) {
        this.tip = tip;
    }
}
