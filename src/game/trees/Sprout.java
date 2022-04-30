package game.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.enemies.Goomba;

import java.util.Random;

public class Sprout extends TreeAbstract {
    Random rand = new Random();


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
        if (rand.nextInt(100) <= 10) {
            if (!location.containsAnActor()) {
                location.addActor(new Goomba());
                System.out.println("Goomba spawned:");
            }
        }

    }
}
