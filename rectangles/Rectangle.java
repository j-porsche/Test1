package rectangles;

import java.awt.Color;
import java.io.Serializable;

public class Rectangle implements Serializable {
    
    int x;
    int y;
    int width;
    int height;
    Color color; 
    boolean filled;
    
    public Rectangle() {
	this.color = Color.BLACK;
    }

    public Rectangle(int x, int y, int width, int height, Color color, boolean filled) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.color = color;
	this.filled = filled;
    }
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    

}
