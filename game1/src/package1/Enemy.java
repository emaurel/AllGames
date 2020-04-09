package game1.src.package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class Enemy extends GameObject {

    private Handler handler;
    protected Color coloration;
    protected int height;
    protected int width;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 50)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 25)
            velX *= -1;

            handler.addObject(new Trail(x, y, ID.Trail, coloration, height, width, 0.02f, handler));

    } 
    


    public void render(Graphics g) {
        g.setColor(coloration);
        g.fillRect(x, y, height, width);

    }

    public Rectangle HitBox() {
        return new Rectangle(x, y, height, width);
    }


}