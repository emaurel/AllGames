package game1.src.package1;

import java.util.LinkedList;

import java.awt.Graphics;
import java.util.Random;


public class Handler {
    HUD hud;
    public boolean isReset;
    private Random r;
    int test;

    LinkedList<GameObject> object;


    public Handler(){
        isReset = false;
        object = new LinkedList<GameObject>();
        r = new Random();
        hud = new HUD();
        test = 0;
    }

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            //System.out.println(test);
            //test++;
            tempObject.tick();
        }
        isAlive();

        if(isReset) {
            startGame();
            isReset = false;
        }
    }

    public boolean isAlive() {
        if (hud.HEALTH == 0) {
            object.clear();
            if (hud.getScore() > hud.getBestScore()) {
                hud.setBestScore(hud.getScore());
            }
            return false;

        } else {
            hud.setScore(hud.getScore() + 1);
            return true;
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

    public void startGame(){
        hud.setHealth(100);
        hud.setScore(0);
        hud.setLevel(1);
        object.clear();
        addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, this));
        addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, this));
        System.out.println("vie :" + hud.getHealth());

    }


}