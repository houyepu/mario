package game.wallet;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Resettable;
import game.actions.PickUpCoinAction;

/**
 * Coin is designed as an item
 */
public class Coin extends Item implements Resettable {
    /**
     * Coin has value
     */
    private final int value;

    /**
     * Coin constructor that is inherited from Item and an additional attribute of value
     *
     * @param name
     * @param displayChar
     * @param portable
     * @param value
     */
    public Coin(String name, char displayChar, boolean portable, int value) {
        super(name, displayChar, portable);
        this.value = value;
        this.registerInstance();
    }

    /**
     * Get coin's value
     *
     * @return Coin's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Override the item pick up action so that when a player picks up a coin it is using pick up coin action instead
     *
     * @param actor
     * @return
     */
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpCoinAction(this);
    }

    @Override
    public void resetInstance(GameMap map) {

    }
}
