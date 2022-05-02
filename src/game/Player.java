package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.actions.*;
import game.consumables.SuperMushroom;
import game.wallet.Coin;

import java.util.List;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable{

	private final Menu menu = new Menu();

	private int powerUpTime;

	/**
	 * This is a global attribute of wallet. Because we think that for the design requirement there will only be one player hence this
	 * means that one player can only have one single wallet. Therefore it is easier to make wallet a global var.
	 */
	public static int wallet;

	private static Player player;

	/**
	 * Constructor.
	 */
	private Player() {
		super("Mario", 'm', 100);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.powerUpTime = 10;
		wallet = 1000;
		player = null;
		registerInstance();
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
		if (this.hasCapability(Status.STARPOWERED)) {
			this.powerUpTime--;
			System.out.println("Mario is star powered for " + powerUpTime + " more turns");
			if (powerUpTime <= 1) {
				powerUpTime = 10;
				this.removeCapability(Status.STARPOWERED);
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
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	public static Player getInstance() {
		if (player == null) {
			player = new Player();
		}

		return player;
	}

	@Override
	public void resetInstance(GameMap map) {
		resetMaxHp(100);
		this.removeCapability(Status.TALL);
		this.removeCapability(Status.STARPOWERED);
	}
}
