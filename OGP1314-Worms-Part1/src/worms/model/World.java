package worms.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Random;

import asteroids.model.Ship;
import asteroids.model.SpaceObject;

public class World {

private double width, height;
private boolean[][] passableMap;
	
public World(double width, double height,boolean[][] passableMap, Random random) throws IllegalArgumentException  {//zoals in interface	
	this.setWidth(width);
	this.setHeight(height);
	this.passableMap = passableMap;
}

private void setWidth(double newWidth) throws IllegalArgumentException {
	if(!isValidSize(newWidth)) {throw new IllegalArgumentException();} // catch aan te vullen in facade
	else {width = newWidth;}
	}

public  double getWidth() {
	return this.width;
	}


private void setHeight(double newHeight) throws IllegalArgumentException {
	if(isValidSize(newHeight)) {throw new IllegalArgumentException();}
	else {height = newHeight;}
}	

public double getHeight() {
	return this.height;
	}


public boolean isValidSize(double size) {
	if (!Double.isNaN(size) &&  (0 <= size) && (size <= Double.MAX_VALUE))
			{return true;}
	else {return false;}
	}

public double getPixelAreaWidth(){
	return getWidth()/ passableMap.length;
}

//public Set<Worm> getWorms() {  //hb 
	//Set<Worm> Worms = new HashSet<Worm>(); //hier maak ik dus een set aan 'Worms'
//	return Worms;
//}

	
}





