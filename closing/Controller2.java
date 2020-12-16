package closing;

import java.awt.event.*;

public class Controller2 extends KeyAdapter {

    public void keyPressed(KeyEvent e) {

        super.keyPressed(e);
        
        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            
            System.exit(0);
        }
    }
}
