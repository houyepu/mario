package game;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.PiranhaPlant;

public class WarpPipe extends Ground {
    public WarpPipe() {
        super('c');
        spawnedPiranhaPlant = false;
    }
    boolean spawnedPiranhaPlant; // if this WarpPipe has spawned a piranha plant since it was created

    @Override
    public void tick(Location location) {
        super.tick(location);
        if (!spawnedPiranhaPlant){
            location.addActor(new PiranhaPlant());
            System.out.println("A Piranha Plant grows from the Warp Pipe! Kill it to allow jumping into the pipe!");
            spawnedPiranhaPlant = !spawnedPiranhaPlant;
        }
    }
}
