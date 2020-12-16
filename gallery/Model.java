package gallery;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Model {

    ResourceBundle language;
    ResourceBundle german;
    ResourceBundle english;
    
    Locale l1 = new Locale("en", "GB");
    Locale l2 = new Locale("de", "DE");
    
    public void initialise() {
	
	this.english = (PropertyResourceBundle) PropertyResourceBundle.getBundle("gallery/resource/resource",l1);
	this.german = (PropertyResourceBundle) PropertyResourceBundle.getBundle("gallery/resource/resource",l2);
	this.language = this.english;
	
    }
    
}
