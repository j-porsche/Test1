package rectangles;

public class Launcher {

    public static void main(final String[] args) {
	final View v = new View();
	SplashScreen ss = new SplashScreen();
	Controller controller = new Controller();
	
	v.initialise(controller);
	ss.initialise(v);
	controller.initialize(v);
	
	try {
	    Thread.sleep(3000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	
	ss.dispose();
    }
}
