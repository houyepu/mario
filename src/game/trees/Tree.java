package game.trees;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Status;


public abstract class Tree extends Ground  {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Tree(char displayChar) {
        super(displayChar);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.STARPOWERED);
    }
}
