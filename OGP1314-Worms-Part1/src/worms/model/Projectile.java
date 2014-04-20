package worms.model;

public class Projectile extends GameObject {

private Worm worm;	

private double newX,newY;

/**
//KLOPT NIET
public Projectile(Worm worm, Vector position, double angle, double) throws IllegalArgumentException{
	this.worm = worm;
	this.newX = worm.getPosition().getPositionX() + (Math.cos(worm.getOrientation()) * worm.getRadius()); 
	this.newY = worm.getPosition().getPositionY() + (Math.sin(worm.getOrientation()) * worm.getRadius());
	
	if (!Worm.getPosition().validX(newX) || !Worm.getPosition().validY(newY))
			throw new IllegalArgumentException();
		
	}
	
	
public Projectile(World world, Position position, double angle, double forceTime, double propulsionYield)
	
}
	// wat ik dacht maar klopt ook niet
//waar is getPositionX en getPositionY naartoe in klasse Worm
public Projectile(Worm worm, double radius  ){
	super((worm.getPosition().getPositionX()+1.1*worm.getRadius()),(worm.getPosition().getPositionY()+1.1*worm.getRadius()), radius, worm.getOrientation());
	
}
*/

public Projectile(World world, double x, double y) {
	// TODO Auto-generated constructor stub
}