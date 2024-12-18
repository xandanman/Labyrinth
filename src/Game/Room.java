package Game;

import Enums.Difficulty;
import Enums.EntityType;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;

public class Room {
    public final int HEIGHT = 20;
    public final int WIDTH = 20;
    private char[][] floorPlan;
    private Entity[][] entities;
    //TODO: zien hoe we entity gaan structureren
    private Player player;
    private Difficulty difficulty;


    public Room(Difficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.floorPlan = new char[HEIGHT][WIDTH];
        this.entities = new Entity[HEIGHT][WIDTH];
        this.player = new Player(player.getName(), player.getX(), player.getY());
    }

    public Player getPlayer() {
        return player;
    }

    private void createFloorPlan() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (j == 0 || j == WIDTH - 1) {
                    floorPlan[i][j] = '|';
                } else if (i == 0 || i == HEIGHT - 1) {
                    floorPlan[i][j] = '-';
                }else {
                    floorPlan[i][j] = ' ';
                }
            }
        }
    }

    public void drawRoom() {
        createFloorPlan();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(floorPlan[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isFinished(){
        Entity door = null;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (entities[i][j] != null && entities[i][j].getType().equals(EntityType.DOOR)) {
                    door = entities[i][j];
                    break;
                }
            }
        }
        return door != null && player.getX() == door.getX() && player.getY() == door.getY();
    }

    public boolean isFree(int x , int y){
        ArrayList<Entity> walls = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (entities[i][j] != null && entities[i][j].getType().equals(EntityType.WAlL)) {
                    walls.add(entities[i][j]);
                }
            }
        }
        for (Entity wall : walls) {
            if (wall.getX() == x && wall.getY() == y) {
                return false;
            }
        }
        return true;
    }

    public void teleport(){
        //TODO: if player is on portal, teleport to another portal

        ArrayList<Entity> portals = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (entities[i][j] != null && entities[i][j].getType().equals(EntityType.PORTAL)) {
                    portals.add(entities[i][j]);
                }
            }
        }
        for (Entity portal : portals) {
            if (player.getX() == portal.getX() && player.getY() == portal.getY()) {
                for (Entity portal1 : portals) {
                    if (portal1 != portal) {
                        player.move(portal1.getX(), portal1.getY());
                    }
                }
            }
        }
    }

    public void update(int newX, int newY){
        //TODO: update room and move player chack if player can move and if so move player
        //TODO: check if player is on portal and teleport

        int oldX = player.getX();
        int oldY = player.getY();

        player.move(newX, newY);

        if (isFree(newX, newY)){
            if (entities[oldX][oldY] != null && entities[oldX][oldY].getType().equals(EntityType.PORTAL)){
                floorPlan[oldX][oldY] = entities[oldX][oldY].toString().charAt(0);
                
            }else if (entities[newX][newY] != null && entities[newX][newY].getType().equals(EntityType.PORTAL)){
                teleport();
                
            }else {
                floorPlan[oldX][oldY] = ' ';
            }
            floorPlan[newX][newY] = player.toString().charAt(0);
        }

    }
  
}
