package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.MonologueAction;

public class MonologueBehaviour implements Behaviour {
    /**
     * A talk timer to keep track the monologue each round
     */
    private int talkTimer;

    /**
     * talke timer will start as 1
     */
    public MonologueBehaviour() {
        talkTimer = 1;
    }

    /**
     * This is a loop for checking each every 2nd turn is monologue action created
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return Do nothing action / MonologueAction
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!map.contains(actor))
            return null;
        // talk timer if talk timer is less than 0 then it will reset back to 1
        if (talkTimer <= 0) {
            talkTimer = 1;
            return new MonologueAction(actor);
        }
        // else it will reduce by 1
        else {
            talkTimer--;
        }
        // do nothing
        return new DoNothingAction();
    }
}
