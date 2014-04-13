package worms.model;

public class Projectile extends GameObject {

private Worm worm;	

private double newX,newY;

	
public Projectile(Worm worm, Vector position, double angle, double) throws IllegalArgumentException{
	this.worm = worm;
	this.newX = worm.getPosition().getPositionX() + (Math.cos(worm.getOrientation()) * worm.getRadius()); 
	this.newY = worm.getPosition().getPositionY() + (Math.sin(worm.getOrientation()) * worm.getRadius());
	
	if (!Worm.getPosition().validX(newX) || !Worm.getPosition().validY(newY))
			throw new IllegalArgumentException();
		
	}
	
	
public Projectile(World world, Position position, double angle, double forceTime, double propulsionYield)
	
}
