package worms.model;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;

import java.util.ArrayList;
import java.util.List;

public class Team {
	public Team(String name){
		this.setName(name);
	}


/**
 * Set the name of the team.
 * @param GivenName
 * 		 
 *
 * @throws IllegalArgumentException
 * 		   The given name has to be valid.
 *           | ValidName(GivenName) == FALSE;
 *         
 * @post  The name of the team is equal to the given name.
 *			 | new.getName() == GivenName;
 * 
 */
public void setName(String GivenName) throws IllegalArgumentException {
		if (isValidName(GivenName))
			{this.name=GivenName;}

		else 
			throw new IllegalArgumentException("This isn't a valid name.");	
}

private String name;


/**
 * Check whether the name for the worm is valid.
 * @param name
 * 		  The name for the team that has to be checked
 * 
 * @return TRUE if the name is valid, False if the name is not valid.
 * 		 
 */
@Model
public boolean isValidName(String name) {

	if (name.length() < 2)
		{return false ;}
	else if (!Character.isUpperCase(name.charAt(0)))
		{return false ;}

	else if (name.matches("[a-zA-Z'\" ]*"))
		{return true ;}
	else
	{ return false;  }
}

/**
 * Get the name of the worm.
 * @return the name of the worm.
 */
@Basic
public String getName() {
	return name; 
}

public void setWorld(World world) throws IllegalArgumentException, IllegalStateException{
	if (! possibleWorld(world))
		throw new IllegalArgumentException(world+" is not valid to set");
	if (hasWorld())
		throw new IllegalStateException();
	this.world=world;
	}


public boolean possibleWorld (World World){
	return (World != null) && (!World.hasTeam(this));
}

public boolean hasWorld(){
	return(!(getWorld()== null));
}

public void removeWorld() throws NullPointerException{
	if (! hasWorld())
		 throw new NullPointerException();
	World formerWorld = getWorld();
	this.world = null;
	formerWorld.removeTeam(this);
}
private World world;

public World getWorld(){
	return this.world;
	}
public boolean PossibleWorm(Worm worm){
	return(worm !=null);
}

public boolean hasWorm(Worm worm){
	return CollectionWorms.contains(worm);
}
public void addWorm(Worm worm) throws IllegalArgumentException, IllegalStateException{
	if(!PossibleWorm(worm))
		throw new IllegalArgumentException(worm+" is not assigned");
	if ((worm.getWorld() != this.getWorld()) || (hasWorm(worm)))
		throw new IllegalStateException();
	CollectionWorms.add(worm);
}
public void removeWorm(Worm worm) throws IllegalArgumentException,IllegalStateException{
if ((worm == null) || (! hasWorm(worm)))
	throw new IllegalArgumentException(worm+" is not assigned");
if (worm.hasTeam())
	throw new IllegalStateException();
CollectionWorms.remove(worm);
}

public List<Worm>getWormCollection(){
	return this.CollectionWorms;
}

private final List<Worm>CollectionWorms = new ArrayList<Worm>();







}



