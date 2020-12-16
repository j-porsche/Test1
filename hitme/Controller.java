package hitme;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
// CAUTION! Do NOT use * here, since class "Timer"
// is ambiguous between java.util and javax.swing!
import javax.swing.Timer;

public class Controller extends MouseAdapter implements ActionListener {

    Model model;
    View view;
    Timer timer;
    // The size of the view component.
    Rectangle box;

    public void initialise(Model m, View v, Rectangle b) {

        this.model = m;
        this.view = v;
        this.timer = new Timer(1000, this);
        this.box = b;

        this.timer.start();
    }

    public void actionPerformed(ActionEvent e) {

        // The old time.
        long o = this.model.time;
        this.model.time = System.currentTimeMillis() / this.model.frequency;

        if (this.model.time != o) {
    
            Target t = null;
    
            // Remove old targets.
            for (Iterator<Target> i = this.model.targets.iterator(); i.hasNext();) {
    
                t = i.next();
    
                t.ageTarget(this.model.time * this.model.frequency);
    
                // CAUTION! The target is NOT visible anymore
                // as soon as its age has reached its lifespan,
                // since the colour is set to transparent then
                // in "Target::fadeColour".
                // But the target object still exists.
                // It therefore has to be removed from the container
                // here, so that the garbage collector can clean it up.
                if (t.age > t.lifespan) {
    
                    i.remove();
                }
            }
    
            // Add new target.
            t = new Target();
    
            t.initialise(this.box);
    
            this.model.targets.add(t);
            this.model.markChanged();
            this.model.notifyObservers();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
        if (e.getButton() == MouseEvent.BUTTON1) {
        
            Point p = e.getPoint();

            for (Iterator<Target> i = this.model.targets.iterator(); i.hasNext();) {

                Target t = i.next();

                if (t.containsPoint(p)) {

                    this.model.score = this.model.score + t.score;

                    i.remove();

                    this.model.markChanged();
                    this.model.notifyObservers();
                }
            }
        }
    }
}
