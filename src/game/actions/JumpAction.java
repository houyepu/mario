package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.highgrounds.HighGround;

import java.util.Random;

public class JumpAction extends Action {
    private final Random rand = new Random();
    @Override
    public String execute(Actor actor, GameMap map) {


        char displayChar = location.getGround().getDisplayChar();


        if (rand.nextInt(100) <= highGround.getJumpSuccessChance()) {
            System.out.println("Successful jump");
        }
        else {
            Player.getInstance().hurt(highGround.getJumpFailureDamage());
            System.out.println("Mario falls and takes " + highGround.getJumpFailureDamage() + " damage!");
        }




        return null;
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
     * Constructor.
     *
     * @param location the location to jump to
     */

    protected HighGround highGround;
    public JumpAction(Location location, String direction) {
        this.location = location;
        this.direction = direction;
        highGround = (HighGround) location.getGround();
    }

    @Override
    public String menuDescription(Actor actor) {
        return (actor + " jumps to high ground at " + direction);
    }

}
