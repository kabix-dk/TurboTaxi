package model.client;

import model.Position;

public class AnonymousClient extends Client {

    private int tip;

    public AnonymousClient(Position position, int type) {
        super(position, type);
        this.tip = 7;
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
