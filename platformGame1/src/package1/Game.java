package platformGame1.src.package1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -6621527432158294095L;

    public static int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    public Game() {
        handler = new Handler();
        thread = new Thread();
        this.addKeyListener(new KeyImput(handler));
        new Window(WIDTH, HEIGHT, "jeu", this);
        handler.startGame();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            final long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS : " + frames);

            }
        }
        stop();
    }

    private void tick() {
        handler.tick();

    }

    public static int mur2(int val, final int min, final int max) {
        if (val > max) {
            return val = min;
        }
        if (val < min) {
            return val = max;
        } else
            return val;
    }

    public static int mur(int val, final int min, final int max) {
        if (val > max) {
            return val = max;
        }
        if (val < min) {
            return val = min;
        } else
            return val;
    }




    private void render() {
        final java.awt.image.BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        final Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        g.dispose();
        bs.show();
    }

    public static void main(final String[] args) {
        new Game();
    }

}