package closing;

import java.awt.*;

public class MainFrame extends Frame {

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        
        Font f = new Font("Serif", Font.PLAIN, 18);
        
        g.setFont(f);
        g.drawString("Zum Beenden ESC dr�cken!", 10, 50);
    }
}
