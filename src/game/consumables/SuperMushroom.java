package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import game.Player;
import game.Status;
import game.actions.DropPowerStarAction;
import game.actions.DropSuperMushroomAction;

/**
 * Class representing the SuperMushroom consumable
 */
public class SuperMushroom extends ConsumableItem{

    /**
     * Constructor
     */
    public SuperMushroom() {
        super("Super Mushroom", '^', true);
    }

    /**
     * Consume the super mushroom -> power up effects
     */
    @Override
    public void consume() {
        super.consume();
        Player.getInstance().increaseMaxHp(50);
        Player.getInstance().addCapability(Status.TALL);
    }
}
