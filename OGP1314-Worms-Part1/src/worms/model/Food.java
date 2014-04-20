package worms.model;


public class Food extends GameObject {
	
private World world;	
private Vector Position;
private static double FOOD_RADIUS = 0.20;

/**
 * Creates a new food.
 * @param world
 * @param position
 * 		  The initial position of the space object.
 *  @effect Food is initialized as a GameObject with a given position and radius.
 *        | super(position, FOOD_RADIUS)
 * @effect the world of this food ..........
 *         
 */	
public Food(World world, Vector position){
	super(position, FOOD_RADIUS);
	this.setWorld(world);
}


public void setWorld(World world) throws IllegalStateException{
	if (hasWorld())
		throw new IllegalStateException();
	this.world =world;
	}

public boolean possibleWorld (World World){
	return (world!= null) && (!world.hasFood(this));
}

public boolean hasWorld(){
	return(!(getWorld()== null));
}

public void removeWorld() throws NullPointerException{
	if (! hasWorld())
		 throw new NullPointerException();
	World formerWorld = getWorld();
	this.world = null;
	formerWorld.removeFood(this);
}


public World getWorld(){
	return this.world;
	}

public void setPosition(Vector newPosition) {
	this.Position = newPosition;
	}

public Vector getPosition() {	
	return this.Position;
	}

private World World;

private double x;

private double y;


public void setX (double x){
	this.x=x;
}

public void setY (double y){
	this.y=y;
}

public double getX(){
	return this.x;
}
public double getY(){
	return this.y;
}

public boolean isActive(){
	if (this.terminated==0){
		return true;
	}
	else { return false;}
}

public void terminated(){
	this.terminated=1;
}
private int terminated;


}