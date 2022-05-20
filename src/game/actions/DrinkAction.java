package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Player;
import game.fountain.Bottle;

public class DrinkAction extends Action{
    @Override
    public String execute(Actor actor, GameMap map) {
        String water = Bottle.bottle.pop();
        if(water == "HealthWater"){
            Player.getInstance().heal(50);
        }
        else if(water == "PowerWater"){

        }
        return "Player has drank some water";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Mario drinks water";
    }
}
