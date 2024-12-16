package Highscore;


import java.time.LocalTime;

public class Score {
    private String name;
    private LocalTime time;


    public Score(String name, LocalTime time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
