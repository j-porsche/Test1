package mvc;

import java.awt.*;
import javax.swing.*;

public class ColourView extends JFrame implements View {

    JButton yellow;
    JButton green;
    Model model;

    public ColourView() {
	
	this.yellow = new JButton("Yellow");
	this.green = new JButton("Green");

	add(yellow, BorderLayout.WEST);
	add(green, BorderLayout.CENTER);
    }
    
    public void update() {

	this.yellow.setBackground(this.model.colour);
	this.green.setBackground(this.model.colour);
    }
}
