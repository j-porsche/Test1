package hitme;

import javax.swing.*;

public class HitMe {

    public static void main(String[] args) {

        Model m = new Model();
        ScoreBoard b = new ScoreBoard();
        View v = new View();
        JFrame f = new JFrame("HitMe Game");
        Controller c = new Controller();

        m.initialise();
        m.addObserver(v);
        m.addObserver(b);

        b.initialise(m);
        v.initialise(m, c);

        f.add(v);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setVisible(true);

        c.initialise(m, v, f.getBounds());
    }
}
