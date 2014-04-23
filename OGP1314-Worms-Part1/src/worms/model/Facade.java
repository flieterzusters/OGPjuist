

//ik heb alle methode van facade auto (uit gui) laten plaatsen dus hier zijn nog veel fouten

package worms.model;

import java.util.Collection;
import java.util.Random;




public class Facade implements IFacade {

	
	@Override
	public boolean canMove(Worm worm) {
		return worm.movePossible(nbSteps); //nbSteps wordt niet meer meegegeven als vroeger(methode in worm aanpassen)
	}
	


	

	@Override
	public boolean canTurn(Worm worm, double angle) {
		return worm.TurnPossible(angle);
	}

	@Override
	public void turn(Worm worm, double angle) {
		worm.turn(angle);
	}





	@Override
	public double[] getJumpStep(Worm worm, double t) {
		return worm.getJumpStep(t);
	}

	@Override
	public double getX(Worm worm) {
		return worm.getPositionX();
	}
	
	@Override
	public double getY(Worm worm) {
		return worm.getPositionY();
	}
	

	@Override
	public double getOrientation(Worm worm) {
		return worm.getOrientation();
	}

	@Override
	public double getRadius(Worm worm) {
		return worm.getRadius();
	}

	@Override
	public void setRadius(Worm worm, double newRadius) {
		try{worm.setRadius(newRadius);}
		catch(IllegalArgumentException illegalargument){
			throw new ModelException(illegalargument);
		}
	}

	@Override
	public double getMinimalRadius(Worm worm) {
		return worm.getMinRadius();
	}

	@Override
	public int getActionPoints(Worm worm) {
		return worm.getActionPoint();
	}

	@Override
	public int getMaxActionPoints(Worm worm) {
		return worm.getMaxPossiblePoints();
	}

	@Override
	public String getName(Worm worm) {
		return worm.getNaming();
	}

	@Override
	public void rename(Worm worm, String newName) {
	   worm.changeNaming(newName); 

	}

	@Override
	public double getMass(Worm worm) {
		return worm.getMass();
	}


	@Override
	public void addEmptyTeam(World world, String newName) {
		try{
			world.addTeam(new Team(newName));
			}
			catch(IllegalArgumentException illegalArgument){
				throw new ModelException(illegalArgument);
			}	
	}

	@Override
	public void addNewFood(World world) {
		world.addNewFood();
	}


	@Override
	public void addNewWorm(World world) {
		world.addNewWorm();	
	}


	@Override
	public boolean canFall(Worm worm) {
		return worm.canFall();
	}





	@Override
	public Food createFood(World world, double x, double y) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public World createWorld(double width, double height,
			boolean[][] passableMap, Random random) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Worm createWorm(World world, double x, double y, double direction,
			double radius, String name) throws IllegalArgumentException {

		Vector position = new Vector(x,y);
		try {Worm wormpie = new Worm(world, position,direction,radius,name);
			return wormpie;}
		catch(IllegalArgumentException illegalargument) {
			throw new ModelException(illegalargument);
		}
	}

	
	

	@Override
	public void fall(Worm worm) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Projectile getActiveProjectile(World world) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Worm getCurrentWorm(World world) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Food> getFood(World world) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getHitPoints(Worm worm) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double[] getJumpStep(Projectile projectile, double t) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getJumpTime(Projectile projectile, double timeStep) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getJumpTime(Worm worm) {
		return worm.getJumpTime();
	}
	
	@Override
	public double getJumpTime(Worm worm, double timeStep) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getMaxHitPoints(Worm worm) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getRadius(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getRadius(Projectile projectile) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getSelectedWeapon(Worm worm) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getTeamName(Worm worm) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getWinner(World world) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<Worm> getWorms(World world) {
	world.getWorms();
	}


	@Override
	public double getX(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getX(Projectile projectile) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getY(Food food) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double getY(Projectile projectile) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isActive(Food food) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isActive(Projectile projectile) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAdjacent(World world, double x, double y, double radius) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isAlive(Worm worm) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isGameFinished(World world) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isImpassable(World world, double x, double y, double radius) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void jump(Projectile projectile, double timeStep) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void jump(Worm worm)throws IllegalArgumentException {
		try {worm.Jump();}
		catch(IllegalArgumentException illegalargument)	{
				throw new ModelException(illegalargument);
				}
	}
	
	@Override
	public void jump(Worm worm, double timeStep) throws IllegalArgumentException{
		try {worm.Jump();}
		catch(IllegalArgumentException illegalargument)	{
				throw new ModelException(illegalargument);
				}
	}

	@Override
	public void move(Worm worm, int nbSteps) throws IllegalArgumentException {
		try { worm.Move(nbSteps);}    
		catch(IllegalArgumentException illegalargument)	{
			throw new ModelException(illegalargument);
		}
	}
	
	@Override 
	public void move(Worm worm) {//nieuwe methode 
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectNextWeapon(Worm worm) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void shoot(Worm worm, int yield) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startGame(World world) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void startNextTurn(World world) {
		// TODO Auto-generated method stub
		
	}

}