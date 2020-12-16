package homunculus;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {

    public MainPanel(Controller c) {

	super();

	ImagePanel imagePanel = new ImagePanel(c);
	JPanel umgebung = new UmgebungsPanel(c);
	BorderLayout l = new BorderLayout();

	c.imagePanel = imagePanel;

	this.setLayout(l);
	this.add(imagePanel, BorderLayout.WEST);
	this.add(umgebung, BorderLayout.CENTER);
    }
}
