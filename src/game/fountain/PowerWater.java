package game.fountain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Player;
import game.Status;
import game.consumables.ConsumableItem;

public class PowerWater extends Water{
    public PowerWater() {
        super("PowerWater",'P',true);
    }
    public void consume(){
        // raise base attack damage
        System.out.println("Mario has drank power water.");
    }
}

