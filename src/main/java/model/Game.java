package model;

import view.maps.Maps;

public class Game {

    private final static int MAX_PETROL_LEFT = 40;

    private Player player;
    private String[] mapCopy = Maps.generateSuperMap();

    public Game() {
    }

    public boolean canMove(Position newPosition, Player player) {
        if(newPosition.getX() >= Maps.sizeX || newPosition.getX() < 0 ) {
            return false;
        }
        if(newPosition.getY() >= Maps.sizeY || newPosition.getY() < 0) {
            return false;
        }
        if(mapCopy[newPosition.getY()].charAt(newPosition.getX()) == Field.BUILDING){
            return false;
        }
        return true;
    }

    public boolean move(Player player, int direction) {
        if(player == null){
            return false;
        }

        Position newPosition;

        switch (direction) {
            case Direction.UP:
                newPosition = new Position(player.getPosition().getX(), player.getPosition().getY()-1);
                break;
            case Direction.DOWN:
                newPosition = new Position(player.getPosition().getX(), player.getPosition().getY()+1);
                break;
            case Direction.LEFT:
                newPosition = new Position(player.getPosition().getX()-1, player.getPosition().getY());
                break;
            case Direction.RIGHT:
                newPosition = new Position(player.getPosition().getX()+1, player.getPosition().getY());
                break;
            default:
                return false;
        }

        if(!canMove(newPosition, player)){
            return false;
        }


        player.setPetrolLeft(player.getPetrolLeft() - 1);
        visitPetrolStation(player);
        player.setPosition(newPosition);
        return true;
    }

    private void visitPetrolStation(Player player) {
        if (mapCopy[player.getPosition().getY()].charAt(player.getPosition().getX()) == Field.PETROL_STATION){
            int dif = Math.min(player.getCashLeft(), MAX_PETROL_LEFT-player.getPetrolLeft());
            player.setPetrolLeft(player.getPetrolLeft() + dif);
            player.setCashLeft(player.getCashLeft() - dif);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
