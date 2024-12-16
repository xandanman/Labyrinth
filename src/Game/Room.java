package Game;

import Enums.Difficulty;

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

    public void isFinished(){
        //TODO: implementeren
    }

    public void isFree(){
        //TODO: check if place is free
    }

    public void teleport(Entity[][] entities){
        //TODO: if player is on portal, teleport to another portal
    }

    public void update(){
        //TODO: update room and move player chack if player can move and if so move player
        //TODO: check if player is on portal and teleport
    }

    public Player getPlayer() {
        return player;
    }
}
