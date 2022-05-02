package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;
import game.highgrounds.HighGround;

import java.util.Random;

public class JumpAction extends Action {
    private final Random rand = new Random();

    /**
     *
     * @param actor The actor performing the jump.
     * @param map The map the actor is on.
     * @return Where the player has successfully jumped to OR how much damage they took on the failed jump.
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        char displayChar = location.getGround().getDisplayChar();

        if (actor.hasCapability(Status.TALL)) {
            map.moveActor(Player.getInstance(), location);
            return ("Successful jump to (" + location.x() + "," + location.y()+")");
        } else if (rand.nextInt(100) <= highGround.getJumpSuccessChance()) {
            map.moveActor(Player.getInstance(), location);
            return ("Successful jump to (" + location.x() + "," + location.y()+")");
        } else {
            Player.getInstance().hurt(highGround.getJumpFailureDamage());
            return ("Mario falls and takes " + highGround.getJumpFailureDamage() + " damage!");
        }

    }



    /**
     * The Location that is jumped to
     */
    protected Location location;

    /**
     * The direction of jump.
     */
    protected String direction;

    /**
     * Used to ensure the jump is being performed on a high ground.
     */
    protected HighGround highGround;

    /**
     * Constructor.
     *
     * @param location the location to jump to
     * @param direction the direction the jump is being made in
     */
    public JumpAction(Location location, String direction) {
        this.location = location;
        this.direction = direction;
        highGround = (HighGround) location.getGround();
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a message for the player console describing the jump.
     */
    @Override
    public String menuDescription(Actor actor) {
        if (!location.containsAnActor()) {
            return (actor + " jumps to high ground at " + direction);
        }
        return null;

    }

}
