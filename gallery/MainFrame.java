package gallery;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class MainFrame extends JFrame {

    JMenu file;
    JMenuItem exit;
    JMenu settings;
    JMenuItem german;
    JMenuItem english;
    JMenu help;
    JMenuItem about;
    Model model;

    public void initialise(Controller controller, Model m) {

	this.model = m;

	buildMenu(controller);
	buildPanel(controller);

	setTitle("Gallery");
	setSize(800, 600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
    }

    public void buildMenu(Controller controller) {
	JMenuBar mb = new JMenuBar();
	this.file = new JMenu();
	this.exit = new JMenuItem();
	this.settings = new JMenu();
	this.german = new JRadioButtonMenuItem();
	this.english = new JRadioButtonMenuItem();
	this.help = new JMenu();
	this.about = new JMenuItem();
	ButtonGroup bg = new ButtonGroup();

	this.exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
	this.german.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, Event.CTRL_MASK));
	this.english.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
	this.about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));

	this.exit.setActionCommand("exit");
	this.german.setActionCommand("german");
	this.english.setActionCommand("english");
	this.about.setActionCommand("about");

	this.exit.addActionListener(controller);
	this.german.addActionListener(controller);
	this.english.addActionListener(controller);
	this.about.addActionListener(controller);

	this.file.add(this.exit);
	this.settings.add(this.german);
	this.settings.add(this.english);
	this.help.add(this.about);

	mb.add(this.file);
	mb.add(this.settings);
	mb.add(this.help);

	bg.add(this.english);
	bg.add(this.german);
	this.english.setSelected(true);

	setJMenuBar(mb);
    }

    private void buildPanel(Controller c) {
	LayoutManager lm_grid = new GridLayout(0, 3, 5, 5);
	this.setLayout(lm_grid);
	String p = "gallery/image";
	File f = new File(p);
	String[] s = f.list();

	for (String string : s) {
	    ImageIcon i_icon = new ImageIcon(p + "/" + string);
	    JButton jb = new JButton(i_icon);
	    jb.setActionCommand("show");
	    jb.addActionListener(c);
	    this.getContentPane().add(jb);
	}

    }

    @Override
    public void paint(Graphics g) {
	super.paint(g);

	this.file.setText(this.model.language.getString("file"));
	this.exit.setText(this.model.language.getString("exit"));
	this.settings.setText(this.model.language.getString("settings"));
	this.german.setText(this.model.language.getString("german"));
	this.english.setText(this.model.language.getString("english"));
	this.help.setText(this.model.language.getString("help"));
	this.about.setText(this.model.language.getString("about"));
	
	this.exit.setMnemonic(this.model.language.getString("file").charAt(0));
	this.file.setMnemonic(this.model.language.getString("exit").charAt(0));
	this.settings.setMnemonic(this.model.language.getString("settings").charAt(0));
	this.german.setMnemonic(this.model.language.getString("german").charAt(0));
	this.english.setMnemonic(this.model.language.getString("english").charAt(0));
	this.help.setMnemonic(this.model.language.getString("help").charAt(0));
	this.about.setMnemonic(this.model.language.getString("about").charAt(0));
    }
}
