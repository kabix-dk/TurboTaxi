package model.client;

import model.Position;

public class CasualClient extends Client {

    private int tip;

    public CasualClient(Position position, int type) {
        super(position, type);
        this.tip = 4;
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
