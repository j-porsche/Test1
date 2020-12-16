package homunculus;

import java.awt.*;
import javax.swing.*;

public class DetailPanel extends JPanel {

    private JLabel label;

    public DetailPanel() {

	this.label = new JLabel();

	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	this.add(this.label);
    }

    public Icon getIcon() {

	return this.label.getIcon();
    }

    public void setIcon(Icon icon) {

	this.label.setIcon(icon);
    }
}
