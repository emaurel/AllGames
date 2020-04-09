package platformGame1.src.package1;

import java.awt.Graphics;
import java.util.Random;

import basicGame.src.package1.Game;

import java.awt.Color;


public class Rock extends GameObject {

    Handler handler;
    int distance;
    private Random r;



    public Rock(int x, int y, ID id, Handler handler, int height, int width) {
        super(x, y, id);

        this.handler = handler;
        this.height = height;
        this.width = width;


    }

    public void tick() {

        x = Game.mur(x, 0, Game.WIDTH - 45);
        y = Game.mur(y, 0, Game.HEIGHT - 75);

        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);

        g.fillRect(x, y, width, height);
    }



}