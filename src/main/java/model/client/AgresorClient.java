package model.client;

import model.Position;

public class AgresorClient extends Client{

    private int tip;

    public AgresorClient(Position position, int type) {
        super(position, type);
        this.tip = 1;
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
