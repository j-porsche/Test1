package PasswordField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;



public class Main {

	public static void main(String[] args) {
		
		
		//Fenster erstellen
		JFrame rechner = new JFrame();
		rechner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rechner.setTitle("Rechner");
		rechner.setSize(800, 600);
		rechner.setLayout(new FlowLayout());
		rechner.setLocationRelativeTo(null);
		rechner.setLayout(new java.awt.BorderLayout());
		
		
		//Panel
		JPanel beschriftungen = new JPanel();
		JPanel rechnungen = new JPanel();
		JPanel abspann = new JPanel();
		
		
		//Label
		JLabel operand1 = new JLabel("1. Operand: ");
		JLabel operand2 = new JLabel("2. Operand: ");
		JLabel ergebnis = new JLabel("");
		
		
		//ComboBox Operator
		String operation[] = {"+" , "-" , "*" , "/"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox operator= new JComboBox(operation);
		
		
		//Inputfields
		JTextField a = new JTextField(8);
		JTextField b = new JTextField(8);
		
		//Checkbox - check for int
		JCheckBox checkint = new JCheckBox("Check Input?");
		
		//Button
		JButton lösen = new JButton("=");
		rechner.getRootPane().setDefaultButton(lösen);
		lösen.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int erg = 0;
				int op1 = 0;
				int op2 = 0;
				
				if (checkint.isSelected()) {
					if (a.getText().matches("\\d+") ) {
						op1 = Integer.parseInt(a.getText());
						op2 = Integer.parseInt(b.getText());
					} else {
						a.setText("int only");
						b.setText("int only");
					}
				} else {
					op1 = Integer.parseInt(a.getText());
					op2 = Integer.parseInt(b.getText());
				}
				
				
				
				switch (operator.getSelectedIndex()) {
				case 0:
					erg = op1 + op2;
					break;
				case 1:
					erg = op1 - op2;
					break;
				case 2:
					erg = op1 * op2;
					break;
				case 3:
					erg = op1 / op2;
				default:
					break;
				}
				
				ergebnis.setText("" + erg);
				
				
			}
		});
		
		
		

		//Radiobuttons
		JRadioButton rad1 = new JRadioButton("Ich habe noch eine Frage.");
		JRadioButton rad2 = new JRadioButton("Danke.");
		JRadioButton rad3 = new JRadioButton("Der Taschenrechner löst all meine Probleme!");
		
		//Buttongroups
		ButtonGroup bewertung = new ButtonGroup();
		bewertung.add(rad1);
		bewertung.add(rad2);
		bewertung.add(rad3);
		
		//Label
		JLabel blabel = new JLabel("Danke für Ihre Aufmerksamkeit");
		JPanel bewertungspanel = new JPanel();
		bewertungspanel.setVisible(false);
		bewertungspanel.add(blabel);
		bewertungspanel.add(rad1);
		bewertungspanel.add(rad2);
		bewertungspanel.add(rad3);
		
		
		//Liste
		String[] list = {"Wir kommen zum Ende.", "Ich würde gern die Quellen sehen!"};
		String[] quellen = {"https://www.java-tutorial.org/jpanel.html", "https://www.java-tutorial.org/jbutton.html", "https://www.zum.de/Faecher/Inf/RP/Java/Dokumente/Java%20Tutorial%20%20Einfache%20GUI.htm", "https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html", "https://www.youtube.com/watch?v=Kmgo00avvEw&ab_channel=BroCode", "https://www.programcreek.com/java-api-examples/?api=javax.swing.ListSelectionModel"};
		
		@SuppressWarnings({"rawtypes", "unchecked" })
		JList quellenliste = new JList(quellen);
		JPanel quellpanel = new JPanel();
		quellpanel.add(quellenliste);
		quellpanel.setVisible(false);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		
		JList liste = new JList(list);
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JButton listconfirm = new JButton("Submit");
		listconfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(liste.isSelectedIndex(0)) {
					quellpanel.setVisible(false);
					bewertungspanel.setVisible(true);
					
				} else {
					bewertungspanel.setVisible(false);
					quellpanel.setVisible(true);
				}
				
			}
		});
		
		
		
		
		
		//Beschriftungspanel
		beschriftungen.add(operand1);
		beschriftungen.add(operand2);
		beschriftungen.add(checkint);
		//Rechnungspanel
		rechnungen.add(a);
		rechnungen.add(operator);
		rechnungen.add(b);
		rechnungen.add(lösen);
		rechnungen.add(ergebnis);
		//frame
		rechner.add(beschriftungen, java.awt.BorderLayout.NORTH);
		rechner.add(rechnungen, java.awt.BorderLayout.CENTER);
		rechner.add(abspann, java.awt.BorderLayout.SOUTH);
		
		//Abspann
		abspann.setLayout(new java.awt.BorderLayout());
		abspann.add(liste, java.awt.BorderLayout.NORTH);
		abspann.add(listconfirm, java.awt.BorderLayout.CENTER);
		abspann.add(bewertungspanel, java.awt.BorderLayout.EAST);
		abspann.add(quellpanel, java.awt.BorderLayout.SOUTH);
		
		
		
		rechner.setVisible(true);
	}
}