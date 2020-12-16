package rectangles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class Controller implements ActionListener, MouseListener, MouseMotionListener {

    private static final String FILENAME = "rectangles/zeichnung.xml";

    View view;

    public void initialize(final View v) {
	this.view = v;

    }

    public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();

	if (this.view.colour == source) {
	    JButton button = (JButton) source;
	    Color c = JColorChooser.showDialog(null, "Farbe", button.getBackground());
	    button.setBackground(c);
	} else if (this.view.clear == source) {
	    this.view.canvas.rectangles.clear();
	    this.view.canvas.rectangle = null;
	    this.view.repaint();
	} else if (this.view.load == source) {
	    try {
		FileInputStream fin = new FileInputStream(Controller.FILENAME);
		BufferedInputStream bin = new BufferedInputStream(fin);
		XMLDecoder decoder = new XMLDecoder(bin);
		view.canvas.rectangles = (Vector<Rectangle>) decoder.readObject();
		decoder.close();
		this.view.repaint();
	    } catch (Exception ex) {
		System.err.println("alles kaputt"); // write to stderr
	    }
	} else if (this.view.save == source) {
	    try {
		FileOutputStream fout = new FileOutputStream(Controller.FILENAME);
		BufferedOutputStream bout = new BufferedOutputStream(fout);
		XMLEncoder encoder = new XMLEncoder(bout);
		encoder.writeObject(view.canvas.rectangles);
		encoder.close();
	    } catch (Exception ex) {
		System.err.println("alles kaputt"); // write to stderr
	    }
	} else if (this.view.filled == source) {

	}

    }

    public void mouseDragged(MouseEvent e) {
	
	int x = 0;
	int y = 0;
	
	x = e.getX();
	y = e.getY();
	
	if (x > this.view.canvas.rectangle.x && y > this.view.canvas.rectangle.y) {
	
	   this.view.canvas.rectangle.width = x - this.view.canvas.rectangle.x;
	   this.view.canvas.rectangle.height = y - this.view.canvas.rectangle.y;
	   
	   if(e.isShiftDown()) {
	    
	       this.view.canvas.rectangle.height = this.view.canvas.rectangle.width;
	       
	   }
	   
	   this.view.repaint();
	}
    }

    public void mouseMoved(MouseEvent e) {
	
	
    }

    public void mouseClicked(MouseEvent e) {
	// TODO Automatisch generierter Methodenstub
	
    }

    public void mousePressed(MouseEvent e) {
	this.view.canvas.rectangle = new Rectangle(e.getX(),e.getY(),0,0,this.view.colour.getBackground(), this.view.filled.isSelected());	
	
    }

    public void mouseReleased(MouseEvent e) {
	
	if(this.view.canvas.rectangle.height > 0 && this.view.canvas.rectangle.width > 0) {
	    
	    this.view.canvas.rectangles.add(this.view.canvas.rectangle);
	}
    }

    public void mouseEntered(MouseEvent e) {
	// TODO Automatisch generierter Methodenstub
	
    }

    public void mouseExited(MouseEvent e) {
	// TODO Automatisch generierter Methodenstub
	
    }

}
