package game2.src.package1;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected float velX, velY;
    protected Handler handler;

    public GameObject(int x, int y, ID id, Handler handler) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
    }

	public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle HitBox();

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setID(ID id){
        this.id = id;
    }
    public ID getID(){
        return id;
    }
    public void setVelX(float velX){
        this.velX = velX;
    }
    public void setVelY(float velY){
        this.velY = velY;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }
}
