package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;

/**
 * Toad is speaking to the player
 */
public class MonologueAction extends Action{
    /**
     * A frog boi
     */
    private final Actor toad;

    ArrayList<String> monologue;

    /**
     * Constructing a toad
     * @param toad
     */
    public MonologueAction(Actor toad) {
        this.toad = toad;
        monologue = new ArrayList<String>();
    }

    /**
     * Speak something
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        monologue.add("You better get back to finding the Power Stars.");
        monologue.add("The Princess is depending on you! You are our only hope.");
        monologue.add("Being imprisoned in these walls can drive a fungus crazy :(");
        monologue.add("You might need a wrench to smash Koopa's hard shells.");
        return monologue.get(selectRandomNum(0,3));
        //Not extendable needs to be fixed with a hashmap, but for now try to get it working at least.
        //Sample code waiting for consume and equip action to be implemented
        // if wrench was equipped then selectRandomNum(0,2)
        // if consume super mushroom then selectRandomNum(1,3)
        // if both then selectRandomNum(1,2)
    }

    /**
     * Description
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Wanna hear something?";
    }

    public int selectRandomNum(int min, int max){
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

}
