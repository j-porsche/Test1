package mvc;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Controller implements ActionListener {

    Model model;
    java.util.List<View> views;
    
    public Controller() {
	
	this.views = new ArrayList<View>();
    }

    public void actionPerformed(ActionEvent e) {
	
	String cmd = e.getActionCommand();
	
	if (cmd.equals("yellow")) {

	    this.model.colour = Color.YELLOW;
	    
	} else if (cmd.equals("green")) {
	    
	    this.model.colour = Color.GREEN;
	    
	} else {

	    System.err.println("Fehler: Unbekanntes Kommando!");
	}

	for (View v : this.views) {
	    
	    v.update();
	}
    }
}
