package worms.model;

public class Projectile {

private Worm worm;	

private double newX,newY;

	
public Projectile(Worm worm) throws IllegalArgumentException{
	this.worm = worm;
	this.newX = worm.getPosition().getPositionX() + (Math.cos(worm.getOrientation()) * worm.getRadius()); 
	this.newY = worm.getPosition().getPositionY() + (Math.sin(worm.getOrientation()) * worm.getRadius());
	
	if (!Worm.getPosition().validX(newX) || !Worm.getPosition().validY(newY))
			throw new IllegalArgumentException();
		
	}
	
	
	
	
}
