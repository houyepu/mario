package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.*;

import java.util.Stack;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable{

	/**
	 * A console menu displaying all the actions that Mario can take
	 * @see Menu
	 */
	private final Menu menu = new Menu();

	/**
	 * Time for which Mario will be powered up by PowerStar
	 */
	private int powerUpTime;

	/**
	 * This is a global attribute of wallet. Because we think that for the design requirement there will only be one player hence this
	 * means that one player can only have one single wallet. Therefore it is easier to make wallet a global var.
	 */
	public static int wallet;

	/**
	 * Static reference to the player (used in conjunction with singleton pattern)
	 */
	private static Player player;

	public static int playerPunchDamage;

	public static int fireFlowerTurnsRemaining = 0;


	/**
	 * Constructor.
	 */
	private Player() {
		super("Mario", 'm', 100);
		this.addCapability(Status.HOSTILE_TO_ENEMY); // Makes this actor hostile to the enemy
		this.powerUpTime = 10; // powerUpTime lasts for 10 turns (countdown not started)
		wallet = 1000; // Initial starting amount of money
		player = null; // Player reference is null
		registerInstance(); // Registers this instance as resettable
		playerPunchDamage = 5;
	}

	/**
	 * Player's play turn
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return			 the Action to be completed this turn
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		// Test Reset Action
		if (ResetAction.useTime == 0) {
			actions.add(new ResetAction());
		}
		// If this player is star powered -> start countdown for how long
		if (this.hasCapability(Status.STARPOWERED)) {
			this.powerUpTime--;
			System.out.println("Mario is star powered for " + powerUpTime + " more turns");
			// If time is up
			if (powerUpTime <= 1) {
				powerUpTime = 10; // Reset the timer back
				this.removeCapability(Status.STARPOWERED); // Remove the PowerStar buffs
				System.out.println("The Power Star's effects have worn off!"); // Print message to notify the player
			}
		}

		if (fireFlowerTurnsRemaining > 0) {
			fireFlowerTurnsRemaining--;
			System.out.println();
			if (fireFlowerTurnsRemaining <= 0) {
				this.removeCapability(Status.FIREATTACK);
				System.out.println("The effects of the fire flower have run out!");
			}
			else {
				System.out.println(fireFlowerTurnsRemaining + " turns remain on Mario's fire flower power!");
			}
		}
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}


	/**
	 * Display character
	 * @return Display char
	 */
	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.SHROOMPOWERED) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	/**
	 *
	 * @return Player instance
	 */
	public static Player getInstance() {
		// If there isn't a player instance -> create one
		if (player == null) {
			player = new Player();
		}

		return player;
	}

	/**
	 * Base attack damage increase
	 * @return new intrinsic weapon
	 */

	/**
	 * Resettable implementation; resets players attributes
	 * @param map The map on which this instance exists
	 */
	@Override
	public void resetInstance(GameMap map) {
		resetMaxHp(100); // Resets MaxHP to be 100 and heals to that amount
		this.removeCapability(Status.SHROOMPOWERED); // Removes the SHROOMPOWERED status if applicable
		this.removeCapability(Status.STARPOWERED); // Removes the STARPOWERED status if applicable
		System.out.println("Mario's power-ups have warn off"); // Print notification message
	}
	@Override
	public IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(playerPunchDamage, "punches");
	}

	public void setIntrinsicWeapon(int intrinsicWeapon) {
		playerPunchDamage = intrinsicWeapon;
	}
}
