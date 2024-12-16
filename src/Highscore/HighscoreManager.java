package Highscore;

import java.util.ArrayList;

public class HighscoreManager {
    private ArrayList<Score> scores;

    public HighscoreManager() {
        scores = new ArrayList<>();
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    public ArrayList<Score> getTopScores() {
        //TODO: get top 5 scores
        return scores;
    }

    public void saveToFileEncrypted(String filepath) {
        //TODO: save scores to file encrypted

    }

    public void loadFromFileEncrypted(String filepath) {
        //TODO: load scores from file encrypted
    }

    private String encrypt(String text) {
        //TODO: make encryption logic
        return text;
    }

    private String decrypt(String text) {
        //TODO: make decryption logic
        return text;
    }
}
