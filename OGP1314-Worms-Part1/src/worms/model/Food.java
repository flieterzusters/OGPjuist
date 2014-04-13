package worms.model;

public class Food extends WorldObject {
	
private World world;	
private Vector Position;
	
public Food(World world,Vector position){
	this.setWorld(world);
	this.setPosition(position);
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