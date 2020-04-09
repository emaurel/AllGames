package game1.src.package1;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class KeyImput extends KeyAdapter {

    private Handler handler;

    public KeyImput(Handler handler) {
        this.handler = handler;

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            handler.isReset = false;

            if (tempObject.getID() == ID.Player) {
                // Key events for player 1


                if (key == KeyEvent.VK_Z)
                    tempObject.setVelY(-5);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(5);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(5);
                if (key == KeyEvent.VK_Q)
                    tempObject.setVelX(-5);
            }
            if (tempObject.getID() == ID.RestartButton) {
                if (key == KeyEvent.VK_SPACE){
                handler.isReset = true;
                }

            }


        }

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(1);

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.Player) {
                // Key events for player 1

                if (key == KeyEvent.VK_Z)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_Q)
                    tempObject.setVelX(0);

            }

        }
    }

}