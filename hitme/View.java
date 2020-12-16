package hitme;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class View extends JPanel implements Observer {

    Model model;

    public void initialise(Model m, Controller c) {

        this.model = m;

        addMouseListener(c);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        Color c = Color.WHITE;
        Shape s = null;

        for (Target t : this.model.targets) {

            c = t.fadeColour(t.age);
            s = new Ellipse2D.Double(t.position.x - (t.size / 2), t.position.y - (t.size / 2), t.size, t.size);

            g2d.setColor(c);
            g2d.fill(s);
        }

        g2d.dispose();
    }

    public void update(Observable o, Object arg) {

        repaint();
    }
}
