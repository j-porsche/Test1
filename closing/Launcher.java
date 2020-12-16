package closing;

import java.awt.Color;

public class Launcher {

    public static void main(String[] args) {
	
	MainFrame f = new MainFrame();
	Controller1 c1 = new Controller1();
	Controller2 c2 = new Controller2();

	f.addWindowListener(c1);
	f.addKeyListener(c2);
	f.setTitle("Window Closing Event");
	f.setBackground(Color.LIGHT_GRAY);
	f.setLocation(100, 100);
	f.setSize(800, 600);
	f.setVisible(true);
    }
}
