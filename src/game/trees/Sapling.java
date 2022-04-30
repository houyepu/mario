package game.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Sapling extends Ground {

    public Sapling() {
        super('t');
    }

    int turnsAlive;
    @Override
    public void tick(Location location) {
        turnsAlive+=1;
        if(turnsAlive>=9) { //after 10 turns, time to move to the next stage
            System.out.println("SAPLING GROW UP");
            location.setGround(new Mature());
        }
    }
}
