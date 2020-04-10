package platformGame1.src.package1;

import java.awt.Graphics;

public class Camera extends GameObject {
    Handler handler;
    GameObject follow;

    public Camera(int x, int y, ID id, Handler handler, GameObject follow) {
        super(x, y, id);
        this.handler = handler;
        this.follow = follow;
        gravityOn = false;
    }

    
    public void tick() {
        x = follow.getX();
        y = follow.getY();
        velX = follow.getVelX();
        velY = follow.getVelY();
    }

    
    public void render(Graphics g) {

    }


}