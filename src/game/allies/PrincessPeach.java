package game.allies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Monologue;
import game.actions.*;

public class PrincessPeach extends Ally {
    private Monologue monologue;
    /**
     * Constructor.
     */
    public PrincessPeach() {
        super("Princess Peach", 'P', 1000);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        for (Item item : otherActor.getInventory()) {
            if (item.toString().equals("Key")) {
                actions.add(new RescueAction());
            }
        }

        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        monologue.princessmonologue();
        return new DoNothingAction();
    }


}
