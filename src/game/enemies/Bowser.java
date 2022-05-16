package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.consumables.SuperMushroom;

public class Bowser extends Enemy{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Bowser(String name, char displayChar, int hitPoints) {
        super("Bowser", 'B', 500);
        this.addItemToInventory(new SuperMushroom()); // Adds a super mushroom to the inventory of the Koopa (drops when killed)
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

    @Override
    public void registerInstance() {
        super.registerInstance();
    }
}
