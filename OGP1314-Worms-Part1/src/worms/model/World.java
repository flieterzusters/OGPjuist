package worms.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Random;

import asteroids.model.Basic;
import asteroids.model.Ship;
import asteroids.model.SpaceObject;

//import asteroids.model.Ship;
//import asteroids.model.SpaceObject;

public class World {

private double width, height;
private boolean[][] passableMap;
private Random random;
private Worm worm;


public World(double width, double height,boolean[][] passableMap, Random random) throws IllegalArgumentException  {//zoals in interface	
	this.setWidth(width);
	this.setHeight(height);
	this.passableMap = passableMap;
	this.random = random ;
	
	
	
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
public int getCoordinatePixelX(double x) throws IllegalArgumentException { //catch aanvullen
	if (ValidCoordinateX(x)){
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
		if(passableMap[getCoordinatePixelX(startX)][getCoordinatePixelY(startY)]){
			direction= direction+Double.MIN_VALUE;
			startX= x+radius*(Math.cos(direction));
			startY= y+radius*(Math.sin(direction));
		}
		else return false;
	return true;
	
}
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
	return this.passableMap;
}

public void setPassableMap(boolean[][] map){
	this.passableMap =map;
	
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

/**
 * Removes a game object from this world.
 */
public void removeObject (GameObject object) {
//laten staan zie link met game object terminate()
}




private Set<Worm> CollectionWorms = new HashSet<Worm>();

/**
 */
public void addWormTocollection(Worm wormpie) {
    assert (wormpie !=null);
	(this.getWorms()).add(wormpie);
}

/**
 * Returns a set collecting all the worms.
 * @return
 */
public Set<Worm> getWorms() {
	return CollectionWorms ; 
}


public void addNewWorm() {
	int Xrandom =  this.random.nextInt();
	int Yrandom =  this.random.nextInt();
	double angle =  2 * Math.PI * this.random.nextDouble();
	double radius = Worm.getMinRadiusWorm();
	Vector position = this.adjacentPosition(new Vector(Xrandom,Yrandom),radius);

	if (position == null){throw new IllegalArgumentException();} //als object niet geplaatst kan worden
	else {createWorm(this,position,angle,radius,"RandomNewWorm") ;}
}



private Vector adjacentPosition(Vector position){
	int XcenterMap = (int) Math.round(this.getWidth() /2 ); 
	int YcenterMap = (int) Math.round(this.getHeight()/2) ; 
	int Xtempor = (int) position.getPositionX();
	int Ytempor = (int) position.getPositionY(); 	
	
	while (! isAdjacent(Xtempor,Ytempor)){	
	if (Xtempor < XcenterMap)
		Xtempor = Xtempor + 1;
	if (Xtempor > XcenterMap)
		Xtempor = Xtempor - 1;
	if (Ytempor < YcenterMap) 
		Ytempor = Ytempor +1;
	if (Ytempor > YcenterMap)
		Ytempor = Ytempor -1;
	else 
		return null;
	}
	return new Vector(Xtempor, Ytempor);
}

public void createWorm(World world, Vector position, double angle, double radius, String name){
	Worm wormpje = new Worm(world,position,angle,radius,name);
	this.addWormTocollection(wormpje);
}


public boolean isAdjacent(Vector position, double radius){
	double minDistanceRadius = radius * 0.1 ; 
	if (!Impassable(position.getPositionX(), position.getPositionY(), minDistanceRadius)) 
	return true ;
}


public boolean isAdjacent(double x, double y, double radius) {
	double newRadius = radius * 0.1;
	return ( !isImpassable(x, y, 0) && isImpassable(x, y, newRadius) );
}











public boolean hasFood(Food food) {
	// TODO Auto-generated method stub
	return false;
}

public void removeFood(Food food) {
	// TODO Auto-generated method stub
	
}










}




