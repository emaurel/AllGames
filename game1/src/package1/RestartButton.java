package game1.src.package1;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;


public class RestartButton extends GameObject{

    Handler handler;
    public RestartButton(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 200, 65);
        g.setColor(Color.white);
        g.drawRect(x, y, 200, 65);
        g.setFont(new Font("Bell MT", Font.BOLD, 13));
        g.drawString("PRESS SPACE TO RESTART", 420, Game.HEIGHT/2 - 30);
        
    }

    public Rectangle HitBox() {
        return null;
    }



}