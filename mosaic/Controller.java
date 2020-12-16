package mosaic;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;

public class Controller extends MouseAdapter implements ActionListener{

    public static final String MIX = "Mix";
    public static final String RESET = "Reset";
    public static final String COPY = "Copy";
    public static final String PASTE = "Paste";
    
    public Model model;
    public MainFrame view;
    private int index;
    private Color color;
    
    public void actionPerformed(ActionEvent e) {
	String command = e.getActionCommand();
	if (command.equals(Controller.MIX)) {
	    this.model.mixAllColours();
	} else if (command.equals(Controller.RESET)) {
	    this.model.resetAllColours();
	} else if(command.equals(Controller.PASTE)) {
	    this.model.copyColor(this.index, this.model.storedColour);
	} else if(command.equals(Controller.COPY)) {
	    this.model.storedColour = this.color;
	}
	
	
	this.view.repaint();
	
    }
    
    public void mouseClicked(MouseEvent e) {
        
        super.mouseClicked(e);
        
        Object o =e.getSource();
        int b = e.getButton();
        
        String s = null;
        Color bc = null;
        int i = 0;
        
        if (o instanceof JLabel) {
	    JLabel jl =(JLabel) o;
	    s = jl.getText();
	    bc = jl.getBackground();
	    i = Integer.valueOf(s);
	}
        
        if (b == MouseEvent.BUTTON1) {
            this.model.mixOneColour(i);
            this.view.repaint();
        } else if (b == MouseEvent.BUTTON3) {
            this.index = i;
            this.color = bc;
            //if (e.isPopupTrigger()) {
        	this.view.jPopup.show((Component) e.getSource(), e.getX(), e.getY());
            //}
        }
    }
    
}
