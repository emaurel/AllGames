package game2.src.package1;

import java.util.Random;

public class Spawn {

    private Handler handler;
    public static int score, level;
    private Random r = new Random();

    public Spawn(Handler handler) {
        this.handler = handler;

    }

    public void tick() {
        score++;
        if(score % 200 == 0){
            if(score % 1000 == 0){
                level++;
            }

            for(int i = 0; i < level; i++){
                handler.addObject(new Enemy(0, r.nextInt(Game.HEIGHT - Enemy.height - 32), ID.Enemy, handler, r.nextInt(level) + 50));
            }

        }

    }


}