package mvc;

import javax.swing.*;

public class TextView extends JFrame implements View {
    
    JLabel label;
    Model model;

    public TextView() {

	this.label = new JLabel("empty");
	
	add(this.label);
    }
    
    public void update() {

	this.label.setText(this.model.colour.toString());
	this.getContentPane().setBackground(this.model.colour);
    }
}
