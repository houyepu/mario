package game.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Goomba;

import java.util.Random;

public class Sprout extends Tree {
    private static int goombaSpawnCount = 0;
    private static final int GOOMBA_SPAWN_LIMIT = 10;
    private final Random rand = new Random();


    public Sprout() {
        super('+');
        turnsAlive = 0;
    }

    int turnsAlive;

    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (turnsAlive >= 9) { //after 10 turns, time to move to the next stage
            System.out.println("SPROUTS GROW UP"); //testing purposes only
            location.setGround(new Sapling());
        }
        if (rand.nextInt(100) <= 10 && goombaSpawnCount <= GOOMBA_SPAWN_LIMIT) {
            if (!location.containsAnActor()) {
                location.addActor(new Goomba());
                goombaSpawnCount++;
                System.out.println("Goomba spawned");
            }
        }

    }
}
