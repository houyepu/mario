package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.consumables.SuperMushroom;

public class DropSuperMushroomAction extends DropItemAction {
    private final SuperMushroom superMushroom;

    public DropSuperMushroomAction(SuperMushroom superMushroom){
        super(superMushroom);
        this.superMushroom = superMushroom;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "Super Mushroom cannot be dropped";
    }
}
