package game1.src.package1;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        if (hud.HEALTH == 0) {
            handler.addObject(new RestartButton(400, Game.HEIGHT / 2 - 65, ID.RestartButton));
        }

        if (hud.getScore() % 100 == 0 && hud.getScore() != 0) {
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() % 5 == 0 && hud.getLevel() < 30) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));

            } if (hud.getLevel() % 7 == 0) {
                handler.addObject(new StrongEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.StrongEnemy, handler));

            } else if (hud.getLevel() < 15)
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));

        }

    }

}