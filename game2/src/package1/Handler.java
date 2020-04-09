package game2.src.package1;

import java.util.LinkedList;
import java.awt.Graphics;


public class Handler {
    public boolean isReset;
    public int i;


    LinkedList<GameObject> object;


    public Handler(){
        isReset = false;
        object = new LinkedList<GameObject>();
        i = 0;
    }

    public void tick() {
        i++;
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
            if (object.getFirst().getID() != ID.Player){
                startGame();
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

    public void startGame() {
        Spawn.score = 0;
        Spawn.level = 2;
        object.clear();
        addObject(new Player(Game.WIDTH/2, Game.HEIGHT/2, ID.Player, this));
        addObject(new Enemy(0, 0, ID.Enemy, this, 50));
        addObject(new Enemy(0, Game.HEIGHT - Enemy.height - 32, ID.Enemy, this, 42));

    }

}