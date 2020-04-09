package platformGame1.src.package1;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

    protected int x, y, height, width;
    protected ID id;
    protected int velX, velY;
    protected Rectangle hitBox;
    protected boolean gravityOn;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        gravityOn = true;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    

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
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setID(ID id){
        this.id = id;
    }
    public ID getID(){
        return id;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
    public Rectangle getHitBox(){
        return hitBox;
    }

    public Rectangle copyHitBox(int x,int y,int height,int width){
       Rectangle recCopy = new Rectangle(x, y, height, width);
       return recCopy;
    }

}
