package mvc;

import javax.swing.JFrame;

public class Launcher {

    public static void main(String[] args) {
	
	Model m = new Model();
	ColourView cv = new ColourView();
	TextView tv = new TextView();
	Controller c = new Controller();

	tv.model = m;
	tv.setTitle("Text View");
	tv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	tv.setLocation(400, 100);
	tv.setSize(300, 200);
	tv.setVisible(true);

	cv.model = m;
	cv.yellow.setActionCommand("yellow");
	cv.green.setActionCommand("green");
	cv.yellow.addActionListener(c);
	cv.green.addActionListener(c);
	cv.setTitle("Colour View");
	cv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cv.setLocation(100, 100);
	cv.setSize(300, 200);
	cv.setVisible(true);

	c.model = m;
	c.views.add(cv);
	c.views.add(tv);
    }
}
