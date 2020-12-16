package fenster;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class MainFrame extends Frame {

    int count = 0;
    
    @Override
    public void paint(Graphics g) {

	super.paint(g);
	
	g.drawRect(50, 80, 300, 200);
	g.setColor(Color.CYAN);
	g.drawRect(80, 40, 300, 200);
	g.fillRoundRect(100, 100, 300, 200, 40, 20);

	(this.count)++;
	
	if (this.count == 50) {
	    
	    setBackground(Color.YELLOW);
	}
	
	System.out.println("Zähler: " + this.count);
	g.drawString("Zähler: " + this.count, 50, 100);
    }
}
