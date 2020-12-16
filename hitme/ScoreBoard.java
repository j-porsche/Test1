package hitme;

import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ScoreBoard extends JPanel implements Observer {

    Model model;
    JLabel label;

    public void initialise(Model m) {

        this.model = m;
        this.label = new JLabel();
        JDialog d = new JDialog();

        add(this.label);

        d.add(this);
        d.setLocation(700, 0);
        d.setSize(100, 100);
        d.setVisible(true); 
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        this.label.setText(String.valueOf(this.model.score));
    }

    public void update(Observable o, Object arg) {

        repaint();
    }
}
