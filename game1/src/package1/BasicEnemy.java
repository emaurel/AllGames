package game1.src.package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject {

    private Handler handler;
    protected Color coloration;
    protected int height;
    protected int width;
    public boolean warning;
    public Random r = new Random();
    public boolean p;
    public boolean p2;

    int i = 0;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.coloration = Color.red;
        this.height = 16;
        this.width = 16;
        velX = 5;
        velY = 5;
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
        if (!warning) return new Rectangle(x, y, height, width);
        return new Rectangle(0, 0, 0, 0);

    }

}