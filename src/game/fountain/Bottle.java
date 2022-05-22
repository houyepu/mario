package game.fountain;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Player;
import game.consumables.ConsumableItem;
import java.util.Stack;

public class Bottle extends ConsumableItem  {
    public static Stack<String> bottle = new Stack<String>();
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Bottle(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    @Override
    public void consume() {
        if (bottle.isEmpty()){
            System.out.println("The bottle is empty please refill water from the fountain");
        }
        else if(bottle.pop() == "HealthWater"){
            Player.getInstance().increaseMaxHp(50);


        }
        else if(bottle.pop() == "PowerWater"){
            System.out.println("Mario has drank power water");
        }

    }


}