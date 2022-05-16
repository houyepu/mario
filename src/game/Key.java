package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;

public class Key extends Item {

    private boolean isDropped;

    /***
     * Constructor.
     */
    public Key() {
        super("Key", 'k', true);
        isDropped = false;
    }

    @Override
    public DropItemAction getDropAction(Actor actor) {
        if (!isDropped) {
            togglePortability();
            isDropped = true;
        }
        return super.getDropAction(actor);
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor) {
        if (isDropped) {
            togglePortability();
        }
        return super.getPickUpAction(actor);
    }
}
