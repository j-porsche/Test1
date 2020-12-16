package homunculus;

import javax.swing.JFrame;

public class Launcher {

    public static void main(String[] args) {

	JFrame frame = new JFrame();
	Controller c = new Controller();
	MainPanel mp = new MainPanel(c);

	frame.setTitle("Homunculus");
	frame.setLocation(50, 50);
	frame.setSize(800, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(mp);
	frame.setVisible(true);
    }
}
