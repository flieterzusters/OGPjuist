package worms.model;

import java.util.*;

import worms.util.Util;

/**
 * this class represents the game world of the game "worms".
 *
 */
public class World {

private double width, height;
private boolean[][] passableMap;
private Random random;
private Worm worm;

/**
 * creates a world and initializes some parameters.
 * @param width the given width of the world.
 * @param height the height a world will have.
 * @param passableMap A map which represent a number of pixels where each pixel has the value true or false so to explain if the area is passable or not. 
 * @param random random number generator
 * @effect the new world is given the width value
 * / this.setWidth(width)
 * @effect the new world is given the height value
 *  / this.setHeight(height);
 * @effect the passable map is set to the world
 *  /this.passableMap = passableMap;
 * @post  the provided map is set to the game as gameWorld
 * 	/this.passableMap = passableMap
 * @post random numbers are generated an provided to the game
 * 	/this.random = random
 * @throws IllegalArgumentException if the height or width aren't valid
 * 	/!isValidSize(newWidth) // !isValidSize(newHeight)
 */
public World(double width, double height,boolean[][] passableMap, Random random) throws IllegalArgumentException  {//zoals in interface	
	this.setWidth(width);
	this.setHeight(height);
	this.passableMap = passableMap;
	this.random = random ;
	
	//worms= new LinkedHashSet<Worm>();
	//food = new HashSet<Food>();
	//projectiles = new HashSet<Projectile>();
	//teams= new HashSet<Team>();
	//this.Objects = new HashSet<WorldObject>();	
	
}
/**
 * looks if there are worms left in the game
 *	/gameFinished()
 *if not the next worm is selected and on turn and HitPoints are increased with 10 and ActionPoints to maximumPoints
 *	/iterator=worms.iterator() //setActiveWorm((Worm) iterator.next()) //activeWorm().setActionPoints(activeWorm().getMaxPossiblePoints())
 *	/activeWorm().setHitPoints(activeWorm().getHitPoint()+10)
 */
public void nextTurn(){
	if (gameFinished())
		return;
	if(! iterator.hasNext())
		iterator=worms.iterator();
	setActiveWorm((Worm) iterator.next());
	activeWorm().setActionPoints(activeWorm().getMaxPossiblePoints());
	activeWorm().setHitPoints(activeWorm().getHitPoint()+10);
}
/**
 * initialises the status of the game to not Fisished jet
 * /finished = false
 */
private boolean finished = false;
/**
 * gives the status of the game to look if it is already finished or not
 * @return if the game is finished
 * /return finished
 */
public  boolean gameFinished(){
	return finished;
}
/**
 * when game came to an end game is stopped and alle worms and teams are removerd
 * /this.finished =true	//this.setActiveWorm(null) 	//this.setActiveTeam(null);
 */
public void setFinished(){
	this.finished =true;
	this.setActiveWorm(null);
	this.setActiveTeam(null);
}
/**
 * Assigns the team who can play now.
 * /this.activeTeam=activeTeam
 * @param activeTeam the team who is on turn now
 * @post the new team is on turn.
 */
public void setActiveTeam(Team activeTeam){
	this.activeTeam=activeTeam;
}
/**
 * 
 * @return
 */
public Team getActiveTeam(){
	return this.activeTeam;
}
private Team activeTeam;

public Worm setActiveWorm(Worm worm){
	return this.activeWorm =worm;
}
private Worm activeWorm;

private Iterator<Worm>iterator;
public void startGame(){
	iterator =worms.iterator();
	if(iterator.hasNext());
	setActiveWorm((Worm)iterator.next());
	if (this.getActiveTeam() !=null &&this.getActiveTeam().getWormCollection().size()==0)
		this.removeTeam(this.getTeam());
	setActiveTeam(null);
	setGameStarted();
}


private void setWidth(double newWidth) throws IllegalArgumentException {
	if(!isValidSize(newWidth)) {throw new IllegalArgumentException();} // catch aan te vullen in facade
	else {width = newWidth;}
	}

public  double getWidth() {
	return this.width;
	}


private void setHeight(double newHeight) throws IllegalArgumentException {
	if(!isValidSize(newHeight)) {throw new IllegalArgumentException();}
	else {height = newHeight;}
}	

public double getHeight() {
	return this.height;
	}


public boolean isValidSize(double size) {
	if (Double.isNaN(size) &&  (0 <= size) && (size <= Double.MAX_VALUE))
			{return true;}
	else {return false;}
	}

public double getPixelAreaWidth(){
	return getWidth()/ passableMap[0].length;
}
public double getPixelAreaHeight(){
	return getHeight()/ passableMap.length;
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
		return pixelCoordinate;
		}
	else throw new IllegalArgumentException();	
	}
public boolean ValidCoordinateX(double x) {
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
			return pixelCoordinate;
	}
else throw new IllegalArgumentException();	
}

public boolean ValidCoordinateY(double y) {
	if (y>= 0 && y<=getHeight()){
		return true;}
		else return false;
}


/**
 *  gives the map where menisioned the areas who are passable or not	
 * @return the map where located the passable and impasseble spaces
 */
public boolean[][] getPassableMap(){
	return this.passableMap;
}
/**
 * loads the map for the world and initialises it to the worlds passableMap
 * /this.passableMap =map
 * @param map the map provided which represent the passable and impassable areas
 * @effect the map for the world is created.
 */
public void setPassableMap(boolean[][] map){
	this.passableMap =map;
	
}
/**
 * checks if the provided coordinates and radius of the object is fully into the world and do not pass the boundarys.
 *
 * @param x
 * @param y
 * @param radius
 * @return
 */
public boolean outOfWorld(double x, double y, double radius) {
	if (x+Math.abs(radius)>getWidth())
	return true;
	if (y+Math.abs(radius)>getHeight())
	return true;
	if (x-Math.abs(radius)<0.0)
	return true;
	if (y-Math.abs(radius)<0.0)
	return true;
	else return false;
	
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

public void createWorm(World world, Vector position, double angle, double radius, String name){
	Worm wormpje = new Worm(world,position,angle,radius,name);
	this.addWormTocollection(wormpje);
}


/**
 * 
 * @param position
 * @param radius
 * @return
 */

private Vector adjacentPosition(Vector position, double radius){
	int XcenterMap = (int) Math.round(this.getWidth() /2 ); 
	int YcenterMap = (int) Math.round(this.getHeight()/2) ; 
	int Xtempor = (int) position.getPositionX();
	int Ytempor = (int) position.getPositionY(); 	
	
	while (! isAdjacent(new Vector(Xtempor,Ytempor),radius)){	
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


public boolean isAdjacent(Vector position, double radius){
	double minDistanceRadius = radius * 0.1 ; 
	if (!imPassable(position.getPositionX(), position.getPositionY(), minDistanceRadius)) 
	return true ;
	else return false;
}
/**
 * determines if in a area around the given coordinates and radius the world is impassable or not for an object
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

/*
public boolean isAdjacent(double x, double y, double radius) {
	double newRadius = radius * 0.1;
	return ( !isImpassable(x, y, 0) && !isImpassable(x, y, newRadius) );
}

public boolean isImpassable(double x, double y, double radius){
	if (outOfWorld(x,y, radius))
		return true;
	return checkIfImpassable(x,y,radius);
}
private boolean checkIfImpassable(double x, double y, double radius) {
	double XPixel=(x/getWidth())*getPassableMap()[0].length;
	double YPixel=(y/getHeight())*getPassableMap().length;
	double RadiusInPixels=Math.abs(radius/getWidth()*getPassableMap()[0].length);
	for (int i = (int) Math.floor(XPixel*RadiusInPixels); !Util.fuzzyGreaterThanOrEqualTo(i,  XPixel+RadiusInPixels); i++ ){
		if (i>=0 && i< getPassableMap()[0].length){
			for (int j = (int) Math.floor(YPixel*RadiusInPixels); !Util.fuzzyGreaterThanOrEqualTo(j,  YPixel+RadiusInPixels); j++ ){
				if ((j>=0 && j< getPassableMap().length) && (inRange(Math.abs(i-XPixel),Math.abs(j-YPixel),RadiusInPixels)&& (! getPassableMap()[j][i]))){
					return true;}
			}
			
		}
	}
		return false;
}

*/
public boolean inRange(double i_X, double j_Y, double radius)
{double RadiusInPixels=Math.abs(radius/getWidth()*getPassableMap()[0].length);
	return Math.sqrt(Math.pow(i_X,2)+ Math.pow(j_Y, 2))<=RadiusInPixels;
}

ArrayList<Food>foods= new ArrayList<Food>();

public void addNewFood() throws IllegalArgumentException{
	int X= random.nextInt();
	int Y= random.nextInt();
	Vector location= adjacentPosition(new Vector(X,Y),Food.getFOOD_RADIUS());
	if (location==null)
		throw new IllegalArgumentException();
	createFood(location);
}

private Food createFood(Vector location) {
	Food food = new Food(this, location);
	food.setWorld(this);
	addAsFood(food);
	return food;
	
}
public void addAsFood(Food food) throws IllegalArgumentException,IllegalStateException{
	if(!canHaveAsFood(food))
		throw new IllegalArgumentException();
		if ((food.getWorld()!=this) || (hasFood(food)))
			throw new IllegalStateException();
		this.foods.add(food);
}

private boolean canHaveAsFood(Food food) {
	
	return (!(food == null));
}

public boolean hasFood(Food food) {
	return this.foods.contains(food);
}

public void removeFood(Food food) {
	if (food.isActive())
		food.terminate();
	
}

public List<Worm>worms = new ArrayList<Worm>();

public Worm activeWorm(){
	Worm worm =worms.get(this.getIndex());
	if (worm.getActionPoint() == 0 && worms.size()>1)
		this.nextWorm();
	return worm;
}
public void nextWorm()
{
	this.setIndex(this.getIndex()+1);
}
public int getIndex(){
	return index;
}
public void setIndex(int index){
	if (index>worms.size()-1)
		this.index=0;
	else
		this.index= index;
}

private int index = 0;

private final List<Team> team= new ArrayList<Team>();


public List<Team> getTeam() {
	return this.team;
}
public void removeTeam(Team team) throws IllegalArgumentException, IllegalStateException{
	if (( team==null)|| (! hasTeam(team)))
		throw new IllegalArgumentException("This team is not right"+team);
	if (team.hasWorld())
		throw new IllegalStateException();
	this.team.remove(team);
}
public boolean hasTeam(Team team){
	return this.team.contains(team);
}
public boolean canHaveAsTeam(Team team){
	return(!(team==null));

}
public void createTeam(String name) throws IllegalArgumentException{
	if (name == null || team.size()==10)
			throw new IllegalArgumentException();
	Team team = new Team(name);
	team.setWorld(this);
	addTeam(team);
}

public void addTeam(Team team) throws IllegalArgumentException, IllegalStateException{
	if(! canHaveAsTeam(team))
		throw new IllegalArgumentException(team+" is not a valid team.");
	if ((team.getWorld()!=this)||(hasTeam(team)))
		throw new IllegalStateException();
	this.team.add(team);
	
}
 public int numberOfTeams() {
	 return team.size();
 }
 public int numberOfWorms() {
	 return CollectionWorms.size();
 }
 public int numberOfFood() {
	 return foods.size();
 }


}




