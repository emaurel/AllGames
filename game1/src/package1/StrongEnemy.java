package game1.src.package1;

import java.awt.Color;
import java.util.Random;

import java.awt.Graphics;
import java.awt.Rectangle;

public class StrongEnemy extends GameObject {

    private Handler handler;
    protected Color coloration;
    protected int height;
    protected int width;
    public boolean warning;
    int i = 0;
    public Random r = new Random();
    public boolean p;
    public boolean p2;

    public StrongEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.coloration = Color.blue;
        this.height = 128;
        this.width = 128;
        velX = 2;
        velY = 2;
        warning = true;
        p = r.nextBoolean();
        p2 = r.nextBoolean();
    }

    public void tick() {
        i++;
        if (!warning) {
            if (p) {
                x += velX;
                if (p2) {
                    y += velY;
                } else {
                    y -= velY;
                }
            } else {
                x -= velX;
                if (p2) {
                    y += velY;
                } else {
                    y -= velY;
                }
            }
            if (y <= 0 || y >= Game.HEIGHT - 50)
                velY *= -1;
            if (x <= 0 || x >= Game.WIDTH - 25)
                velX *= -1;

            handler.addObject(new Trail(x, y, ID.Trail, coloration, height, width, 0.02f, handler));
        } else {

            if (i > 50)
                warning = false;
        }

    }

    public void render(Graphics g) {

        if (warning) {
            g.setColor(coloration);
            g.drawRect(x, y, width, height);
        } else {
            g.setColor(Color.black);
            g.drawRect(x, y, width, height);
            g.setColor(coloration);
            g.fillRect(x, y, width, height);
        }

    }

    public Rectangle HitBox() {
        return new Rectangle(x, y, height, width);
    }

}