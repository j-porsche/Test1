package mosaic;

import java.awt.Color;
import java.util.Random;

public class Model {
    private Color[] colours = null;
    public Color storedColour = null;

    public Color[] getColours() {
	return this.colours;
    }

    public void setColours(Color[] colours) {
	this.colours = colours;

    }

    public Color getRandomColour() {
	Random r = new Random();
	int blau = r.nextInt(256);
	int rot = r.nextInt(256);
	int gruen = r.nextInt(256);

	return new Color(rot, gruen, blau);
    }
    
    public void mixOneColour(final int index)
    {
	this.colours[index] = getRandomColour();
    }

    public void mixAllColours() {
	
	for (int i = 0; i < this.colours.length; i++) {
	    mixOneColour(i);
	    
	}
    }
    
    public void resetAllColours() {
	for (int i = 0; i < this.colours.length; i++) {
	    this.colours[i] = Color.WHITE;
	}
    }
    
    public void copyColor(int index, Color color) {
	this.colours[index] = color;
    }
    
}
