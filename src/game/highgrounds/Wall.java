package game.highgrounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.JumpAction;

/**
 * Class representing a wall
 */
public class Wall extends HighGround {

	/**
	 * Constructor
	 * @param displayChar     Character that represents this wall on the map
	 */
	public Wall() {
		super('#');
	}

	/**
	 * Character that will be displayed on the map
	 */
	char displayChar = '#';

	/**
	 * Success chance (as a percentage) to jump onto this
	 */
	public int jumpSuccessChance = 80;
	/**
	 * Damage taken by failing to jump onto this object
	 */
	public int jumpFailureDamage = 20;

	public int getJumpSuccessChance() {
		return jumpSuccessChance;
	}

	public int getJumpFailureDamage() {
		return jumpFailureDamage;
	}

	/**
	 * Checks if actor can enter this tile.
	 * @param actor the Actor attempting to enter
	 * @return if the Actor is able to enter
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.STARPOWERED); // only allows an actor to enter if it is affected by a power star
	}

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
