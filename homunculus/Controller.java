package homunculus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;

public class Controller implements ActionListener, MouseMotionListener
{

    ImagePanel imagePanel;
    DetailPanel detailPanel;
    
    public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
	if(s.equals("yellow_button"))
	{
	    this.detailPanel.setBackground(Color.YELLOW);
	}
	else if(s.equals("red_button"))
	{
	    this.detailPanel.setBackground(Color.RED);
	}
	else {System.err.print("unknown action");}
    }

    public void mouseDragged(MouseEvent e) {
	
    }

    public void mouseMoved(MouseEvent e) {
	Point posMouse= e.getPoint();
	Graphics g = this.imagePanel.getGraphics();
	
	if ((ImagePanel.POLYGON.contains(posMouse)== true) && !ImagePanel.PAINTED) {
	    g.setColor(ImagePanel.COLOR);
	    g.fillPolygon(ImagePanel.POLYGON);
	    Icon i = ImagePanel.determineIcon("homunculus/arm_ventral.jpeg");
	    this.detailPanel.setIcon(i);
	    ImagePanel.PAINTED = true;
	}else if((ImagePanel.POLYGON.contains(posMouse) == false) && ImagePanel.PAINTED){
	    this.imagePanel.update(g);
	    this.detailPanel.setIcon(null);
	    ImagePanel.PAINTED = false;
	}
    }
}
