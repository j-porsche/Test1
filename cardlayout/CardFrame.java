package cardlayout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardFrame extends JFrame implements ItemListener {

    static final String CARD_1 = "card1";
    static final String CARD_2 = "card2";
    static final String CARD_3 = "card3";

    CardLayout layout;
    JPanel panel;

    public CardFrame() {

	JComboBox<String> cb = new JComboBox<String>();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	this.panel = new JPanel();
	this.layout = new CardLayout();

	p1.add(new JButton("Test 1"));
	p1.add(new JButton("Test 2"));
	p1.add(new JButton("Test 3"));

	p2.add(new JCheckBox("Test 1", true));
	p2.add(new JCheckBox("Test 2", false));

	p3.add(new JColorChooser());

	this.panel.setLayout(this.layout);
	this.panel.add(CardFrame.CARD_1, p1);
	this.panel.add(CardFrame.CARD_2, p2);
	this.panel.add(CardFrame.CARD_3, p3);

	cb.addItem(CardFrame.CARD_1);
	cb.addItem(CardFrame.CARD_2);
	cb.addItem(CardFrame.CARD_3);
	cb.addItemListener(this);

	add(this.panel, BorderLayout.CENTER);
	add(cb, BorderLayout.SOUTH);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pack();
	setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {

	if (e.getStateChange() == ItemEvent.SELECTED) {

	    this.layout.show(this.panel, (String) e.getItem());
	}
    }

    public static void main(String[] args) {

	new CardFrame();
    }
}
