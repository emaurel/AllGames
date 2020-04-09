package game1.src.package1;

import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends GameObject {
    Random r = new Random();
    Handler handler;
    HUD hud;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        hud = new HUD();

    }

    public Rectangle HitBox() {
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {

        x = Game.mur(x, 0, Game.WIDTH - 45);
        y = Game.mur(y, 0, Game.HEIGHT - 75);

        x += velX;
        y += velY;

        collision();


    }


    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.StrongEnemy || tempObject.getID() == ID.FastEnemy) {
                if (HitBox().intersects(tempObject.HitBox())) {
                    hud.HEALTH -= 2;
                }
            }

        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }


}