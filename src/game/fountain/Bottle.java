package game.fountain;
import game.Player;
import game.consumables.ConsumableItem;
import java.util.Stack;

public class Bottle extends ConsumableItem  {
    /**
     * Bottle implemented as a stack
     */
    public static Stack<String> bottle = new Stack<String>();

    /**
     * Bottle constructor
     */
    public Bottle() {
        super("Bottle", '_', false);
        togglePortability();
    }

    /**
     * Consume action when bottle is empty it will check and print bottle is empty
     */
    @Override
    public void consume() {
        //Check if bottle is empty
        if (bottle.isEmpty()){
            System.out.println("The bottle is empty please refill water from the fountain");
        }
        //If is health water it will increase player's max hp by 50
        else if(bottle.peek() == "HealthWater"){
            bottle.pop();
            Player.getInstance().increaseMaxHp(50);
        }
        //If is power water it will increase player's attack damage by 15
        else if(bottle.peek() == "PowerWater"){
            bottle.pop();
            Player.playerPunchDamage = 15;
            System.out.println("p");
        }
    }
}