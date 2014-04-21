package worms.model;
//aanpassingstest

public class Bazooka extends Projectile {
private final int yield;
private double massBazooka=0.3;	
private double minForceBazooka=2.5;
private double maxForceBazooka=9.5;
private int maxYield=100;
private int minYield=0;
public Bazooka(World world, double x, double y, int yield)
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
return massBazooka;
}
public int getCostLaunch(){
	return 50;}
public double getForce(){
	return minForceBazooka +(this.getYield()*((maxForceBazooka-minForceBazooka)/maxYield));
}

public double getYield() {
	return this.yield;
}
public int getDamage(){
	return 80;
}
}
