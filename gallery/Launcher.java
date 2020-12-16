package gallery;

public class Launcher {

    public static void main(String[] args) {

	Controller controller = new Controller();
	MainFrame f = new MainFrame();
	Model m = new Model();
	
	m.initialise();	
	f.initialise(controller,m);
	controller.initialise(m,f);

    }
}
