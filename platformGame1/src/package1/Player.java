package platformGame1.src.package1;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;
    int distance;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        height = 64;
        width = 32;
    }

    public void tick() {

        x = Game.mur2(x, 0, Game.WIDTH - 45);
        y = Game.mur2(y, 0, Game.HEIGHT - 75);

        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);

        g.fillRect(x, y, width, height);
    }

}