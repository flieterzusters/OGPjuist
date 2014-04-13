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


public void setWorld(World world){
	this.world =world;
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





}