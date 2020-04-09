package game2.src.package1;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import basicGame.src.package1.Game;
import java.awt.Color;

public class Enemy extends GameObject {
    public int i, c;
    public Color color;
    public static int width = 32, height = 128;
    private Random r = new Random();
    public int speed;


    public Enemy(int x, int y, ID id, Handler handler, int speed) {
        super(x, y, id, handler);
        color = Color.red;
        velX = 50;
        i = 0;
        this.speed = speed;
        velX = speed;
        c = 0;

    }

    public void tick() {
        i++;
        if (i > 70) {
            x += speed;
            handler.addObject(new Trail(x, y, ID.Trail, color, width, height, 0.09f, handler));
            if(x >= Game.WIDTH-45){
                c++;
            }
            x = Game.mur(x, 0, Game.WIDTH - 45);
            if(c == 5){
                handler.removeObject(this);
            }


        }

    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Enemy && tempObject.getY() != y) {
                if (HitBox().intersects(tempObject.HitBox())) {
                    y = r.nextInt(Game.HEIGHT - height - 32);
                    collision();
                }
            }

        }
    }

    public void render(Graphics g) {
        collision();

        if (i > 70) {
            g.setColor(Color.black);
            g.drawRect(x, y, Game.WIDTH, height);
            g.setColor(color);
            g.fillRect(x, y, width, height);
        } else {
            g.setColor(color);
            g.drawRect(x, y, Game.WIDTH, height);
        }

    }

    public Rectangle HitBox() {
        return new Rectangle(x, y, width, height);
    }

}