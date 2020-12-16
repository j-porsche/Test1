package homunculus;

import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel {

    static final int[] X = { 224, 236, 240, 240, 240, 252, 252, 260, 268, 280, 268, 268, 250, 244, 230, 220 };
    static final int[] Y = { 90, 100, 124, 140, 156, 174, 190, 210, 212, 224, 222, 248, 244, 214, 178, 126 };
    static final Polygon POLYGON = new Polygon(ImagePanel.X, ImagePanel.Y, ImagePanel.X.length);
    static final Color COLOR = new Color(1.0f, 0f, 0f, 0.3f);
    static boolean PAINTED = false;

    public ImagePanel(Controller c) {

	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	Icon i = ImagePanel.determineIcon("homunculus/skeleton_ventral.jpeg");
	JLabel l = new JLabel(i);
	
	l.addMouseMotionListener(c);

	this.add(l);
    }

    static Icon determineIcon(String filename) {

	Toolkit defaultTK = Toolkit.getDefaultToolkit();
	ImageIcon result = new ImageIcon(defaultTK.getImage(filename));

	return result;
    }
}
