package game.jumpablegrounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.JumpAction;
import game.actions.TeleportAction;
import game.enemies.PiranhaPlant;

public class WarpPipe extends JumpableGround {

    private boolean spawnedPiranhaPlant; // if this WarpPipe has spawned a piranha plant since it was created
    /**
     * Success chance (as a percentage) to jump onto this
     */
    private int jumpSuccessChance = 100; //teleporting always succeeds
    /**
     * Damage taken by failing to jump onto this object
     */
    private int jumpFailureDamage = 0;

    public WarpPipe() {
        super('c');
        spawnedPiranhaPlant = false;
    }

    public int getJumpSuccessChance() {
        return jumpSuccessChance;
    }

    public int getJumpFailureDamage() {
        return jumpFailureDamage;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        if (!spawnedPiranhaPlant){
            location.addActor(new PiranhaPlant());
            System.out.println("A Piranha Plant grows from the Warp Pipe! Kill it to allow jumping into the pipe!");
            spawnedPiranhaPlant = !spawnedPiranhaPlant;
        }
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        if (!location.containsAnActor() && !actor.hasCapability(Status.STARPOWERED)) {
            // location must be empty to jump to.
            // Also, star powered actors shouldn't have a jump action as they can just walk over high ground
            actions.add(new JumpAction(location, direction));
        }

       /* if (location.containsAnActor()) {
            if (location.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                actions.add(new TeleportAction(connectingPipeLocation));
            }
        }*/

        return actions;
    }
}
