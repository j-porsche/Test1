package homunculus;

import java.awt.*;
import javax.swing.*;

public class UmgebungsPanel extends JPanel {

    public UmgebungsPanel(Controller c) {

	this.setLayout(new BorderLayout());
	
	JPanel buttonPanel = new ButtonPanel(c);
	DetailPanel detailsPanel = new DetailPanel();

	c.detailPanel = detailsPanel;

	this.add(detailsPanel, BorderLayout.CENTER);
	this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
