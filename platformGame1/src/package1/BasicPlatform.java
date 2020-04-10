package platformGame1.src.package1;

import java.awt.Color;
import java.awt.Graphics;

public class BasicPlatform extends GameObject {
    Handler handler;


    public BasicPlatform(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        height = 50;
        width = Game.WIDTH + 4000;
        gravityOn = false;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);

    }




}