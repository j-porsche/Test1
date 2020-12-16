package gallery;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class AboutDialogue extends JDialog {

    public AboutDialogue() {

	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();

	l1.setText("gallery");
	l2.setText("author");
	
	this.add(l1, BorderLayout.NORTH);
	this.add(l2, BorderLayout.CENTER);
	
	// macht den Dialog modal (exklusiv, sperrt Hauptfenster)
	this.setModal(true);
	
	this.setTitle("AboutDialog");
	this.setLocation(400, 400);
	this.setSize(400, 200);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	this.setVisible(true);
	
    }
}
