package model;

import view.maps.Maps;

public class Game {

    private Player player;

    public Game() {
    }

    public boolean canMove(Player player, Position newPosition) {
        if(newPosition.getX() >= Maps.sizeX || newPosition.getX() < 0 ) {
            return false;
        }
        if(newPosition.getY() >= Maps.sizeY || newPosition.getY() < 0) {
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

        if(!canMove(player,newPosition)){
            return false;
        }

        player.setPosition(newPosition);
        return true;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
