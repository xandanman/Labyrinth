package Controller;

import Game.Room;
import Highscore.HighscoreManager;

import java.time.LocalTime;
import java.util.Scanner;

public class Labyrinth {
    private Room room;
    private HighscoreManager highscoreManager;
    private LocalTime startTime;
    private LocalTime endTime;

    public Labyrinth(Room room, HighscoreManager highscoreManager) {
        this.room = room;
        this.highscoreManager = highscoreManager;
        this.startTime = LocalTime.now();
    }

    public void startGame() {

        while (!room.isFinished()) {
            int direction = inputPlayer();
            room.drawRoom();
            room.update(direction);
        }

    }

    public int inputPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move enter 1(right),2(left),3(up),4(down) : ");

        return scanner.nextInt();

    }

}
