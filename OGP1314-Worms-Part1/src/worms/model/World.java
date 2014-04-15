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
	//this.Objects = new HashSet<WorldObject>();
	
	
	
	
	
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
public double getPixelAreaHeight(){
	return getHeight()/ passableMap.Height;
}


/**
 * Returns a set collecting all the worms.
 * 
 * @return
 */
////	Set<Worm> Worms = new HashSet<Worm>(); //hier maak ik dus een set aan 'Worms'
//		for(WorldObject worldobject: Objects)
//			Worms.add((WOrm)WorldObject);
//	return Worms;
//}


public boolean ImPassable(double x, double y,double radius){
	if (outOfWorld(x,y,radius))
		return true;
	for (int i= (int) (x-Math.abs(radius)); i<x+Math.abs(radius);i++){
		if (i>= && i<getPassableMap()[0].length){
			for (int j =(int) (y-Math.abs(radius));j<y+Math.abs(radius);j++){
				if (j>=0 && j<getPassableMap().length)
			}
		}
	}
}

private Object[] getPassableMap() {
	// TODO Auto-generated method stub
	return null;
}

private boolean outOfWorld(double x, double y, double radius) {
	if (x+Math.abs(radius)>getWidth())
	return true;
	if (y+Math.abs(radius)>getHeight())
	return true;
	if (x-Math.abs(radius)<0.0)
	return true;
	if (y-Math.abs(radius)<0.0)
	return true;
	
}
}




