package game.wallet;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.actions.DropCoinAction;
import game.actions.PickUpCoinAction;

/**
 * Coin is designed as an item
 */
public class Coin extends Item {
    /**
     * Coin has value
     */
    private int value;

    /**
     * Coin constructor that is inherited from Item and an additional attribute of value
     * @param name
     * @param displayChar
     * @param portable
     * @param value
     */
    public Coin(String name, char displayChar, boolean portable,int value) {
        super(name,displayChar, portable);
        this.value = value;
    }

    /**
     * Get coin's value
     * @return Coin's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Override the item pick up action so that when a player picks up a coin it is using pick up coin action instead
     * @param actor
     * @return
     */
    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        return new PickUpCoinAction(this);
    }

    public DropItemAction getDropAction(Actor actor) { return new DropCoinAction(this); }


}
