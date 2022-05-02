package game.consumables;

import edu.monash.fit2099.engine.positions.GameMap;

public interface Consumable {

    /**
     * Allows any classes that use this interface to consume an item and reap its benefits
     */
    void consume();

}
