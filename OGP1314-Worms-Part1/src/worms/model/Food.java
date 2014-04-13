package worms.model;


public class Food extends WorldObject {
	
private World world;	
private Vector Position;
private static double foodRadius = 0.20;
	
public Food(World world, Vector position){
	super(position, foodRadius);
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