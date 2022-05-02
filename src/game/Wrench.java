package game;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A wrench used to destroy Koopa's shells and deal heavy damage
 */
public class Wrench extends WeaponItem {
    /**
     * Constructor
     * @see WeaponItem
     */
    public Wrench() {
        super("Wrench", 'W', 50, "wrenches", 80);
    }
}
