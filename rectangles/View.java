package rectangles;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
    
    Canvas canvas;
    JButton colour;
    JButton clear;
    JButton save;
    JButton load;
    
    JCheckBox filled;
    
    void initialise(Controller c) {
	this.canvas = new Canvas();
	this.colour = new JButton("Farbauswahl");
	this.clear = new JButton("Reinigen");
	this.save = new JButton("Speichern");
	this.load = new JButton("Laden");
	this.filled = new JCheckBox("gefüllt");
	
	JPanel p = new JPanel();
	
	this.colour.setBackground(Color.BLACK);
	this.colour.setForeground(Color.WHITE);
	
	this.canvas.addMouseListener(c);
	this.canvas.addMouseMotionListener(c);
	
	this.colour.addActionListener(c);
	this.clear.addActionListener(c);
	this.save.addActionListener(c);
	this.load.addActionListener(c);
	this.filled.addActionListener(c);
	
	p.add(this.colour);
	p.add(this.clear);
	p.add(this.save);
	p.add(this.load);
	p.add(this.filled);
	
	add(this.canvas, BorderLayout.CENTER);
	add(p, BorderLayout.SOUTH);
	
	
	setTitle("Zeichnen");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pack();
	setVisible(true);
    }
}
