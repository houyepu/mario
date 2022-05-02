package game.consumables;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;

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

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation, actor);
    }
}
