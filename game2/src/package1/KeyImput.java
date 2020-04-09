package game2.src.package1;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class KeyImput extends KeyAdapter {

    private Handler handler;
    private int speed;
    private boolean[] keyDown = new boolean[4];

    public KeyImput(Handler handler) {
        this.handler = handler;
        speed = 5;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            handler.isReset = false;

            if (tempObject.getID() == ID.Player) {
                // Key events for player 1

                if (key == KeyEvent.VK_Z) {
                    tempObject.setVelY(-speed);
                    keyDown[0] = true;
                }

                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(speed);
                    keyDown[1] = true;
                }

                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(speed);
                    keyDown[2] = true;
                }

                if (key == KeyEvent.VK_Q) {
                    tempObject.setVelX(-speed);
                    keyDown[3] = true;
                }

            }
        }

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(1);
        if (key == KeyEvent.VK_SPACE)
            handler.startGame();

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {

                if (key == KeyEvent.VK_Z)
                    keyDown[0] = false;

                if (key == KeyEvent.VK_S)
                    keyDown[1] = false;
                if (key == KeyEvent.VK_D)
                    keyDown[2] = false;
                if (key == KeyEvent.VK_Q)
                    keyDown[3] = false;

                if (!keyDown[0] && !keyDown[1]) {
                    tempObject.setVelY(0);
                }

                if (!keyDown[2] && !keyDown[3]) {
                    tempObject.setVelX(0);
                }
            }

        }
    }

}
