

//ik heb alle methode van facade auto (uit gui) laten plaatsen dus hier zijn nog veel fouten

package worms.model;

import java.util.Collection;
import java.util.Random;




public class Facade implements IFacade {

//
//
//
//part1 :::
//
//
//
	
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
		return worm.getPosition().getPositionX();
	}
	
	@Override
	public double getY(Worm worm) {
		return worm.getPosition().getPositionY();
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
		return Worm.minRadiusWorm;
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
	public boolean canMove(Worm worm) {
		return worm.movePossible(); //nbSteps wordt niet meer meegegeven als vroeger(methode in worm aanpassen)
	}
	
	@Override
	public double getJumpTime(Worm worm, double timeStep) { 
		return worm.getJumpTime();
	}

	

	//
	//
	//
	//part2 :::
	//
	//
	//
	

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
		Vector positionFood = new Vector(x,y);
		Food freshFood = new Food(world, positionFood);
		return freshFood;
	}


	@Override
	public World createWorld(double width, double height,
			boolean[][] passableMap, Random random) {
      World newWorld = new World(width,height,passableMap,random);
      return newWorld;
	}

	

	@Override
	public void fall(Worm worm) {
		worm.fall();	
	}


	@Override
	public Projectile getActiveProjectile(World world) {
		world.getActiveProjectile(); //reeds aangevuld
	}


	@Override
	public Worm getCurrentWorm(World world) {
		return world.getActiveWorm();
	}


	@Override
	public Collection<Food> getFood(World world) {
		return getFoods();// reeds aangevuld
	}


	@Override
	public int getHitPoints(Worm worm) {
		return worm.getHitPoint(); //nog aan te passen
	}


	@Override
	public double[] getJumpStep(Projectile projectile, double t) {
		return projectile.getJumpStep(t);
	}


	@Override
	public double getJumpTime(Projectile projectile, double timeStep) {
		return projectile.getJumpTime(timeStep); //nog aan te passen
	}


	@Override
	public int getMaxHitPoints(Worm worm) {
		return worm.getMaxPossiblePoints();
	}


	@Override
	public double getRadius(Food food) {
		return food.getRadius();
	}


	@Override
	public double getRadius(Projectile projectile) {
		return projectile.getRadius();
	}


	@Override
	public String getSelectedWeapon(Worm worm) {
		return worm.getWeapon();
	}


	@Override
	public String getTeamName(Worm worm) {
		return worm.getTeam().getName(); //getteam nog aan te maken
	}


	@Override
	public String getWinner(World world) {
		world.getWinner(); //reeds aangemaakt
	}


	@Override
	public Collection<Worm> getWorms(World world) {
	world.getWorms();
	}


	@Override
	public double getX(Food food) {
		return food.getPosition().getPositionX();
	}
	
	
	@Override
	public double getY(Food food) {
		return food.getPosition().getPositionY();
	}

	
	@Override
	public double getX(Projectile projectile) {
		return projectile.getPosition().getPositionX();
	}


	@Override
	public double getY(Projectile projectile) {
		return projectile.getPosition().getPositionY();
	}


	@Override
	public boolean isActive(Food food) {
		return food.isActive();
	}


	@Override
	public boolean isActive(Projectile projectile) {
		return projectile.isActive();
	}


	@Override
	public boolean isAdjacent(World world, double x, double y, double radius) {
		Vector position = new Vector(x,y);
		return world.isAdjacent(position, radius);
	}


	@Override
	public boolean isAlive(Worm worm) {
		return !worm.isTerminated();
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
		projectile.Jump(timeStep);
		
	}


	
	@Override
	public void jump(Worm worm, double timeStep) throws IllegalArgumentException{ //NIEUWE
		try {worm.Jump();}
		catch(IllegalArgumentException illegalargument)	{
				throw new ModelException(illegalargument);
				}
	}


	
	@Override 
	public void move(Worm worm) {//nieuwe methode 
	  return worm.move();
	}


	@Override
	public void selectNextWeapon(Worm worm) {
		worm.nextWeapon();
	}


	@Override
	public void shoot(Worm worm, int yield) {
		worm.shoot(yield);
	}


	@Override
	public void startGame(World world) {
		world.startGame();
	}


	@Override
	public void startNextTurn(World world) {
		world.nextTurn();
	}
}
	  