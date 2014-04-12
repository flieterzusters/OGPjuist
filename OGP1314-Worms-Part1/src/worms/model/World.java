package worms.model;

import java.util.Random;

public class World {

private double width, height;
	
public World(double width, double height) throws IllegalArgumentException {	
	this.setWidth(width);
	this.setHeight(height);
}

private void setWidth(double newWidth) throws IllegalArgumentException {
	if(!validSize(newWidth)) {throw new IllegalArgumentException();} // catch aan te vullen in facade
	else {width = newWidth;}
	}

public  double getWidth() {
	return this.width;
	}


private void setHeight(double newHeight) throws IllegalArgumentException {
	if(validSize(newHeight)) {throw new IllegalArgumentException();}
	else {height = newHeight;}
}	

public double getHeight() {
	return this.height;
	}


public boolean validSize(double size) {
	if (!Double.isNaN(size) &&  (0 <= size) && (size <= Double.MAX_VALUE))
			{return true;}
	else {return false;}
	}
	
	
	
}





