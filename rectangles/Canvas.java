package rectangles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    
    public Vector<Rectangle> rectangles;
    Rectangle rectangle;

    public Canvas() {
	setBackground(Color.WHITE);
	setPreferredSize(new Dimension(800, 600));
	rectangles = new Vector<Rectangle>();
    }

    protected void paintComponent(Graphics g) {

	super.paintComponent(g);

	for (Rectangle r : this.rectangles) {
	    g.setColor(r.color);

	    if (r.filled) {
		g.fillRect(r.x, r.y, r.width, r.height);
	    } else {
		g.drawRect(r.x, r.y, r.width, r.height);
	    }
	}
	if (this.rectangle != null) {
	    g.setColor(this.rectangle.color);

	    if (this.rectangle.filled) {
		g.fillRect(this.rectangle.x, this.rectangle.y, this.rectangle.width, this.rectangle.height);
	    } else {
		g.drawRect(this.rectangle.x, this.rectangle.y, this.rectangle.width, this.rectangle.height);
	    }
	}

    }

}
