package worms.model;

import java.util.Random;

public class World {

private double width, height;
	
public World(double width, double height) {	
	if (!this.validSize(width) || !this.validSize(height))
		throw new IllegalArgumentException(); // catch aan te vullen in facade
	this.setWidth(width);
	this.setHeight(height);
}

public void setWidth(double width) {
	this.width = width;
	}	

public  double getWidth() {
	return this.width;
	}



public void setHeight(double height) {
	this.height = height;
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





