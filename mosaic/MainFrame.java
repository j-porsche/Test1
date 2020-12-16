package mosaic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

    JLabel[] labels;
    
    public void initialise() {
	
	JPanel colourPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	
	colourPanel.setPreferredSize(new Dimension(400, 400));
	colourPanel.setBackground(Color.LIGHT_GRAY);
	
	add(colourPanel, BorderLayout.CENTER);
	add(buttonPanel, BorderLayout.SOUTH);
	
	GridLayout grid = new GridLayout(7, 7);
	colourPanel.setLayout(grid);
	
	this.labels = new JLabel[49];
	for (int i = 0; i < labels.length; i++) {
	    JLabel jl = new JLabel();
	    jl.setText(String.valueOf(i));
	    jl.setOpaque(true);
	    this.labels[i] = jl;
	    colourPanel.add(this.labels[i]);
	    // colourPanel.add(jl);
	}
	JButton mixButton = new JButton("Mix");
	JButton resetButton = new JButton("Reset");
	buttonPanel.add(mixButton);
	buttonPanel.add(resetButton);
	
	this.setTitle("Mosaic");
	this.pack();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
    }
}
