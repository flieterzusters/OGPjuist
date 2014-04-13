package worms.model;

import be.kuleuven.cs.som.annotate.Basic;




/**
 * hb p 453...
 *creeren van een superclasse voor worm, food  enzo aan te maken (hierarchie creeren)
 *gevolg: super(...) bij argumenten object worm in classe worm
 *in Worm kunnen alle methode uit deze klasse direct aangesproken worden
 *
 */


public abstract class WorldObject {  

private Vector Position;	

/**
 * This indicates the minimal radius a worm should have when he is created.
 */
private final double minRadius=0.25;

/**
 * The worm is shaped as a circle, this circle is defined by this value, it must be greater than the minRadius.  
 */
private double radius;

	
public WorldObject (Vector position, double radius) {
		this.setPosition(position);
		this.setRadius(radius);
}


public void setPosition(Vector newPosition) {
	this.Position = newPosition;
}


public Vector getPosition() {	
	return this.Position;
}

/**
 * gives the worm the radius given by the parameter
 * @param givenradius the new radius of this worm
 * @post the new radius of the worm is equal to the value of the parameter
 * 		/new.getRadius() == radius
 * @throws IllegalArgumentException
 * 				the given radius is not valid
 */
public void setRadius(double givenradius) throws IllegalArgumentException {
	if (validRadius(givenradius)) {
		this.radius= givenradius;
	}
	else throw new IllegalArgumentException("Illegal value for the radius");
}
/**
 * checks if the radius of the worm is a valid radius
 * @param radius the radius witch need to be checked if it is valid or not.
 * @return True if the radius is bigger than the minimal radius or 
 * 			false if the radius is lower than the minimal radius a worm should need to have.
 * 		/radius>minRadius
 */

public boolean validRadius(double radius){
	if (radius>minRadius) {return true;}
	else {return false;}
}

/**
 * basic inspector that returns the radius of the worm.
 * @return the minimal radius that the worm should have
 */
@Basic
public double getMinRadius() {
	return this.minRadius;
}


/**
 * the radius of the worm
 * @return the radius of this worm
 */
@Basic
public double getRadius() {
	return radius;
}




}