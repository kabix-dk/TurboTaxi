package model;

public class Player {

    private int petrolLeft;
    private Position position;

    public Player(int petrol) {
        this.petrolLeft = petrol;
        this.position = new Position(0,0);
    }

    public int getPetrolLeft() {
        return petrolLeft;
    }

    public void setPetrolLeft(int petrolLeft) {
        this.petrolLeft = petrolLeft;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
