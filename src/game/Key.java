package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;

public class Key extends Item {
    /***
     * Constructor.
     */
    public Key() {
        super("Key", 'k', true);
    }

    /**
     * Make it so this item can't be dropped
     * @param actor     Actor doing the dropping
     * @return DropAction
     */
    @Override
    public DropItemAction getDropAction(Actor actor) {
        if (actor.getInventory().contains(this) && actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            togglePortability();
        }
        return super.getDropAction(actor);
    }
}
