package platformGame1.src.package1;

import java.util.LinkedList;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

public class Handler {
    static int t;
    static boolean bouger = true;
    static int d;

    LinkedList<GameObject> object;

    public Handler() {
        object = new LinkedList<GameObject>();
        t = 0;

    }

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
        gravity();

    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
            g.setColor(Color.red);
            g.drawRect(tempObject.getX(), tempObject.getY() + tempObject.getHeight() / 2, tempObject.getWidth(),
                    tempObject.getHeight() / 2);
            g.setColor(Color.green);
            g.drawRect(tempObject.getX(), tempObject.getY(), tempObject.getWidth(),
            tempObject.getHeight() / 2);

        }
    }

    public void gravity() {
        boolean[][] repeated;
        repeated = new boolean[object.size()][object.size()];
        for (int i = 0; i < object.size(); i++) {
            for (int j = 0; j < object.size(); j++) {
                GameObject tempObject = object.get(i);
                GameObject tempObject2 = object.get(j);

                Rectangle downHitbox = tempObject.copyHitBox(tempObject.getX(), tempObject.getY() + tempObject.getHeight() / 2, tempObject.getWidth(),
                tempObject.getHeight() / 2);

                Rectangle downHitbox2 = tempObject2.copyHitBox(tempObject2.getX(), tempObject2.getY() + tempObject2.getHeight() / 2, tempObject2.getWidth(),
                tempObject2.getHeight() / 2);

                Rectangle upHitbox = tempObject.copyHitBox(tempObject.getX(), tempObject.getY(), tempObject.getWidth(),
                        tempObject.getHeight() / 2);

                Rectangle upHitbox2 = tempObject2.copyHitBox(tempObject2.getX(), tempObject2.getY(),
                        tempObject2.getWidth(), tempObject2.getHeight() / 2);
                downHitbox.translate(0, 1);
                if (tempObject.gravityOn && tempObject != tempObject2) {
                    if (downHitbox.intersects(upHitbox2)) {
                        tempObject.setVelY(0);
                        tempObject.setY(Game.mur(tempObject.getY(), 0, tempObject2.getY() - tempObject.getHeight()));
                        if (tempObject.getID() == ID.Player) {
                            bouger = true;
                        }

                    } else if (upHitbox.intersects(downHitbox2) || upHitbox.intersects(upHitbox2)) {
                        System.out.println(tempObject.getID() + "  " + tempObject2.getID());

                        if (tempObject.getX() > tempObject2.getX()) {
                            tempObject.setX(tempObject2.getX() + tempObject2.getWidth());
                        } else {
                            tempObject.setX(tempObject2.getX() - tempObject.getWidth());

                        }

                    } else if (!downHitbox.intersects(upHitbox2)) {
                        if (repeated[j][i]) {
                        } else {
                            tempObject.setVelY(10);
                            repeated[j][i] = true;

                        }
                    }

                }
            }
        }

    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void startGame() {
        addObject(new Player(100, 0, ID.Player, this));
        addObject(new Rock(830, 0, ID.Rock, this, 100, 20));
        for(int i = 0; i < 17; i++){
            addObject(new Rock(750 - 40*i, 0 + 20 *i, ID.Rock, this, 20, 128));
        }

        addObject(new BasicPlatform(0, Game.HEIGHT - 200, ID.BasicPlatform, this));
    }

}