package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.MonologueAction;

public class MonologueBehaviour implements Behaviour {

    private int talkTimer;

    public MonologueBehaviour() {
        talkTimer = 1;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!map.contains(actor))
            return null;

        if (talkTimer <= 0) {
            talkTimer = 1;
            return new MonologueAction(actor);
        }
        else {
            talkTimer--;
        }

        return new DoNothingAction();
    }
}
