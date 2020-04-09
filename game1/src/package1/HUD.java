package game1.src.package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

    public static int HEALTH = 100;
    public static int score = 0;
    public static int level = 1;
    public static int bestScore = 0;

    private int greenValue;
    private int redValue;



    public void tick() {
        HEALTH = Game.vie(HEALTH, 0, 100);
        greenValue = Game.vie(greenValue, 0, 255);
        redValue = Game.vie(redValue, 0, 255);

        greenValue = HEALTH * 2;
        redValue = 100 - HEALTH;

    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(400, 15, 200, 30);
        g.setColor(new Color(redValue, greenValue, 0));
        g.fillRect(400, 15, HEALTH * 2, 30);
        g.setColor(Color.white);
        g.drawRect(400, 15, 200, 30);
        g.setFont(new Font("Bell MT", Font.PLAIN, 13));


        g.drawString("Best score :" + getBestScore(), 10, 24);
        g.drawString("Score :" + getScore(), 10, 48);
        g.drawString("Level :" + getLevel(), 10, 69);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return HEALTH;
    }

    public void setHealth(int health) {
        this.HEALTH = health;
    }

}