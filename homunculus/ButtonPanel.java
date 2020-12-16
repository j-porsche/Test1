package homunculus;

import java.awt.*;
import javax.swing.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel(Controller c) {

	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
	JButton ybutton = new JButton("Yellow");
	JButton rbutton = new JButton("Red");
	
	ybutton.setActionCommand("yellow_button");
	rbutton.setActionCommand("red_button");
	
	ybutton.addActionListener(c);
	rbutton.addActionListener(c);
	
	this.add(ybutton);
	this.add(rbutton);
	
    }
}
