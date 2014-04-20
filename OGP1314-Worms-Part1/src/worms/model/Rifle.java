package worms.model;

public class Rifle extends Projectile {
private final int yield;
private double massRifle=0.01;	
private double ForceRifle=2.5;
private int maxYield=100;
private int minYield=0;
public Rifle(World world, double x, double y, int yield)
		throws IllegalArgumentException {
	super(world, x, y);
	if (! ValidYield(yield))
		throw new IllegalArgumentException();
	this.yield= yield;
}

private boolean ValidYield(int yield) {
	
	return (yield>=minYield) && (yield<=maxYield);
}

public double getMass(){
return massRifle;
}
public int getCostLaunch(){
	return 10;}
public double getForce(){
	return ForceRifle ;
}

public double getYield() {
	return this.yield;
}
public int getDamage(){
	return 20;
}
}
