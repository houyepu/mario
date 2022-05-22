package game.fountain;
import game.Player;
import game.Status;
import game.consumables.ConsumableItem;
import java.util.Stack;

public class Bottle extends ConsumableItem  {
    public static Stack<String> bottle = new Stack<String>();
    public Bottle() {
        super("Bottle", '_', false);
        togglePortability();
    }

    @Override
    public void consume() {
        if (bottle.isEmpty()){
            System.out.println("The bottle is empty please refill water from the fountain");
        }
        else if(bottle.pop() == "HealthWater"){
            Player.getInstance().increaseMaxHp(1000000);
        }
        else if(bottle.pop() == "PowerWater"){
            Player.playerPunchDamage = 15;
            System.out.println("p");

        }

    }
}