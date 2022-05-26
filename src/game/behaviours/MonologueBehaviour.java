package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.MonologueAction;

/**
 * Special behaviour for NPCs/AI that allows them to speak automatically
 */
public class MonologueBehaviour implements Behaviour {
    /**
     * A talk timer counting down to when the actor should speak
     */
    private int talkTimer;

    /**
     * Constructor
     */
    public MonologueBehaviour() {
        talkTimer = 1; // Set the talk timer to one so that actor does not speak on first turn (and then alternates)
    }

    /**
     * This is a loop for checking each every 2nd turn a MonologueAction is created (to be subsequently executed)
     *
     * @param actor the Actor speaking
     * @param map   the GameMap containing the Actor
     * @return The action to perform (MonologueAction or null)
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // If the map does not contain the speaking actor; return null
        if (!map.contains(actor))
            return null;

        // If it is time for the actor to talk
        if (talkTimer <= 0) {
            talkTimer = 1; // Reset talk timer to 1
            return new MonologueAction(actor); // Return MonologueAction with actor as parameter so that dialogue is correctly selected
        } else {
            talkTimer--; // Decrement the talk timer so that the actor will speak next turn
        }

        return null; // If the timer hasn't reached 0 yet or if all else fails
    }
}
