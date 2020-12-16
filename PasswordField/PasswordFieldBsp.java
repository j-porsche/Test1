

package PasswordField;

import javax.swing.*;

public class PasswordFieldBsp {

    public static void main(String[] args) {
	// TODO Automatisch generierter Methodenstub
	JFrame frame = new JFrame();
	
	frame.setSize(300,100);
	frame.setTitle("JPasswordField Bsp");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel panel = new JPanel();
	JLabel pwLabel = new JLabel("Passwort");
	
	JPasswordField pwField = new
	JPasswordField("supersicherespasswort");
	
	panel.add(pwLabel);
	panel.add(pwField);
	frame.add(panel);
	frame.setVisible(true);
		

    }

}
