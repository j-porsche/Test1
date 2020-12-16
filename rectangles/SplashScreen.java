package rectangles;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JWindow;

public class SplashScreen extends JWindow {

    public void paint(Graphics g) {
	super.paint(g);

	drawSmiley(g);

    }
    
    void initialise(View v) {
	this.setSize(400, 300);
	this.setLocationRelativeTo(v);
	this.setVisible(true);
    }
    
    private void drawSmiley(Graphics g) {
	int w = getWidth();
	int h = getHeight();
	int r = w < h ? w : h;
	int x = (w - r) / 2;
	int y = (h - r) / 2;

	// Background
	g.setColor(Color.GREEN);
	g.fillRect(0, 0, w, h);
	// Face
	g.setColor(Color.YELLOW);
	g.fillOval(x, y, r, r);
	// Eyes
	g.setColor(Color.BLACK);
	g.fillOval(x + (r / 4), y + (r / 3), r / 10, r / 10);
	g.fillOval(x + r - (r / 4) - (r / 10), y + (r / 3), r / 10, r / 10);
	// Mouth
	g.setColor(Color.BLACK);
	g.drawArc(x + (r / 4), y + (r / 2), r - (2 * (r / 4)), r / 3, 200, 140);
    }

}
