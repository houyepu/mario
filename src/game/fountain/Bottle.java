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
        String water = bottle.pop();
        if(water == "HealthWater"){
            Player.getInstance().increaseMaxHp(100000);


        }
        else if(water == "PowerWater"){
        }

    }



}