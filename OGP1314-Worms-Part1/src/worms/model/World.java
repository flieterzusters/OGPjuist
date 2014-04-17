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
public int getCoordinatePixelX(double x) throws IllegalArgumentException {
	if (ValidCoordinateX(x){
		double pixelWidth=getPixelAreaWidth();
		int pixelCoordinate = passableMap.length;
		for(double i = passableMap.length; i>=0;){
			if (x>=i){
				break;}
			pixelCoordinate= pixelCoordinate-1;
			i= i-pixelWidth;
			}
		}
		
	}
private boolean ValidCoordinateX(double x) {
	if (x>= 0 && x<=getWidth()){
	return true;}
	else return false;
}
public int getCoordinatePixelY(double y) throws IllegalArgumentException {
	if (ValidCoordinateY(y)){
		double pixelHeight=getPixelAreaHeight();
		int pixelCoordinate = passableMap[0].length;
			for(double i = passableMap[0].length; i>=0;){
				if (y>=i){
					break;}
				pixelCoordinate= pixelCoordinate-1;
				i= i-pixelHeight;
				}
		}
		
	}
private boolean ValidCoordinateY(double y) {
	if (y>= 0 && y<=getHeight()){
		return true;}
		else return false;
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



/**
 * 
 * @param x 
 * 		the x coordinate of the object
 * @param y 
 * 		the y coordinate of the object
 * @param radius 
 * 		the radius coordinate of the object
 * @return 
 * 		looks if the coordinate is not out of the bounds of the world
 */
public boolean imPassable(double x, double y,double radius){
	double direction =0;
	double startX = x;
	double startY = y;
	for (direction=0; direction<=2*(Math.PI);)
		if(PassableMap[getCoordinatePixelX(startX)][getCoordinatePixelY(startY)]){
			direction= direction+Double.MIN_VALUE;
			startX= x+radius*(Math.cos(direction));
			startY= y+radius*(Math.sin(direction));
		}
		else return false;
	return true
	
	
	/*	if (outOfWorld(x,y,radius))
		return true;
	 for (int i= (int) (x-Math.abs(radius)); i<x+Math.abs(radius);i++){
		if (i>=0 && i<getPassableMap()[0].length){
			for (int j =(int) (y-Math.abs(radius));j<y+Math.abs(radius);j++){
				if (j>=0 && j<getPassableMap().length)
					return true break
				}
			}
		}
	}
	return false;
}
	 	*/
	
	
public boolean[][] getPassableMap(){
	return this.PassableMap;
}
public void setPassableMap(boolean[][] map){
	this.passableMap =map;
	
}
private boolean[][] passableMap;

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




