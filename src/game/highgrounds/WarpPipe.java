package game.highgrounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.PiranhaPlant;
import game.highgrounds.HighGround;

public class WarpPipe extends HighGround {
    public WarpPipe() {
        super('c');
        spawnedPiranhaPlant = false;
    }
    boolean spawnedPiranhaPlant; // if this WarpPipe has spawned a piranha plant since it was created

    /**
     * Success chance (as a percentage) to jump onto this
     */
    int jumpSuccessChance = 100; //teleporting always succeeds
    /**
     * Damage taken by failing to jump onto this object
     */
    int jumpFailureDamage = 0;

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
            //location.addActor(new PiranhaPlant());
            System.out.println("A Piranha Plant grows from the Warp Pipe! Kill it to allow jumping into the pipe!");
            spawnedPiranhaPlant = !spawnedPiranhaPlant;
        }
    }
}
