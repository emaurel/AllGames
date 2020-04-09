package platformGame1.src.package1;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class KeyImput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    private int speed;
    int t;
    public static int up;

    public KeyImput(Handler handler) {
        this.handler = handler;
        speed = 10;
        up = 0;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.Player) {

                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(speed);
                    keyDown[2] = true;
                }

                if (key == KeyEvent.VK_Q) {
                    tempObject.setVelX(-speed);
                    keyDown[3] = true;
                }
                if (key == KeyEvent.VK_SPACE && Handler.bouger) {
                    tempObject.setVelY(0);
                    tempObject.gravityOn = false;
                    for (int j = 0; j < 10; j++){
                    tempObject.setVelY(-10*j);
                    Handler.bouger = false;
                    }
                    tempObject.gravityOn = true;

                }
            }

        }

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(1);

        if (key == KeyEvent.VK_R){
            handler.object.clear();
            handler.startGame();
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {

                if (key == KeyEvent.VK_D)
                    keyDown[2] = false;
                if (key == KeyEvent.VK_Q)
                    keyDown[3] = false;

                if (!keyDown[2] && !keyDown[3]) {
                    tempObject.setVelX(0);
                }
            }

        }
    }
}