package gallery;

import java.awt.event.*;
import java.util.EventObject;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Controller implements ActionListener {

    Model model;
    MainFrame view;

    public void actionPerformed(ActionEvent e) {

	String command = e.getActionCommand();

	if (command.equals("exit")) {
	    System.out.println("exit");
	} else if (command.equals("german")) {
	    this.model.language = this.model.german;
	    view.repaint();
	} else if (command.equals("english")) {
	    this.model.language = this.model.english;
	    view.repaint();
	} else if (command.equals("about")) {
	    new AboutDialogue();
	} else if (command.equals("show")) {
	    JButton b = (JButton) e.getSource();
	    Icon i = b.getIcon();

	    JDialog d = new JDialog();
	    JLabel l = new JLabel(i);
	    d.add(l);
	    d.setTitle("Title");
	    d.setLocation(400, 400);
	    d.pack();
	    d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    d.setVisible(true);
	}

    }

    public void initialise(Model m, MainFrame f) {
	this.model = m;
	this.view = f;

    }
}
