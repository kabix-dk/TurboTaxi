package model.client;

import model.Position;

public abstract class Client {

    private Position position;
    private int type;
    private boolean taken;
    private int cost;
    private int tip;

    public Client(Position position, int type) {
        this.type = type;
        this.position = position;
        this.taken = false;
        this.cost = 0;
    }

    public void increaseCost(){
        this.cost++;
    }

    public Position getPosition() {
        return position;
    }

    public int getType() {
        return type;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public int getCost() {
        return cost;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
}
