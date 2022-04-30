package game.trees;


import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Dirt;
import game.enemies.Koopa;
import game.wallet.Coin;

import java.util.Random;

public class Mature extends Ground {

    public Mature() {
        super('T');
    }

    Random rand = new Random();
    int turnsAlive;

    @Override
    public void tick(Location location) {
        turnsAlive += 1;
        if (rand.nextInt(100) <= 20) {
            System.out.println("A MATURE TREE HAS DIED"); //testing purposes only
            location.setGround(new Dirt());
        }
        if (rand.nextInt(100) <= 10) {
            location.addActor(new Koopa());
            System.out.println("Koopa Spawned!");
        }

    }
}
