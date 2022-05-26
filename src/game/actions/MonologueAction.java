package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Player;
import game.Status;
import game.Wrench;

import java.util.ArrayList;

import static game.Status.STARPOWERED;

/**
 * Toad is speaking to the player
 */
public class MonologueAction extends Action {
    /**
     * A frog boi
     */
    private final Actor speakingActor;
    /**
     * Monologue is an arraylist
     */
    ArrayList<String> monologue;

    /**
     * Constructing a toad
     * @param newSpeakingActor
     */
    public MonologueAction(Actor newSpeakingActor) {
        this.speakingActor = newSpeakingActor;
        monologue = new ArrayList<>();
    }

    /**
     * When executed this will print specific lines according to the player's status and whether the player is holding a wrench
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return monologue depending on the action of the player
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        String retString = "";

        // Adding monologues to bowser
        if (speakingActor.toString().equals("Bowser")) {
            monologue.add("Imma show princess peach a real nice time tonight");
            monologue.add("What was that sound? Oh, just a fire.");
            monologue.add("Princess Peach! You are formally invited... to the creation of my new kingdom!");
            monologue.add("Never gonna let you down!");
            monologue.add("Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!");

            retString = monologue.get(selectRandomNum(0, monologue.size() - 1));
            // Adding monologues to toad
        } else if (speakingActor.toString().equals("Toad")) {
            monologue.add("You better get back to finding the Power Stars.");
            monologue.add("The Princess is depending on you! You are our only hope.");
            monologue.add("Being imprisoned in these walls can drive a fungus crazy :(");
            monologue.add("You might need a wrench to smash Koopa's hard shells.");

            //The actor is star powered it will return line 1 to 3
            if (actor.hasCapability(Status.STARPOWERED) & actor.getWeapon().verb().equals("wrenches")){
                return monologue.get(selectRandomNum(1,2));
            }
            else if (actor.hasCapability(Status.STARPOWERED)){
                return monologue.get(selectRandomNum(1,3));
            }
            //The actor has wrenches
            else if (actor.getWeapon().verb().equals("wrenches")){
                return monologue.get(selectRandomNum(0,2));
            }
            //The list will randomly print all the lines
            else{
                System.out.println(actor.getWeapon());
                return monologue.get(selectRandomNum(0,3));
            }
        }
        // Adding monologue to princess peach
        else if (speakingActor.toString().equals("Princess Peach")) {
            monologue.add("Dear Mario, I'll be waiting for you...");
            monologue.add("Never gonna give you up !");
            monologue.add("Release me, or I will kick you!");

            retString = monologue.get(selectRandomNum(0, monologue.size() - 1));
        }
        // Adding monologue to goombas
        else if (speakingActor.toString().equals("Goomba")) {
            monologue.add("Mugga mugga!");
            monologue.add("Ugha ugha... (Never gonna run around and desert you...)");
            monologue.add("Ooga-Chaka Ooga-Ooga!");
            retString = monologue.get(selectRandomNum(0, monologue.size() - 1));
        }
        // Adding monologue to koopa
        else if (speakingActor.toString().equals("Koopa")) {
            monologue.add("Never gonna make you cry!");
            monologue.add("Koopi koopi koopii~!");
            retString = monologue.get(selectRandomNum(0, monologue.size() - 1));
        }
        // Adding monologue to piranha plant
        else if (speakingActor.toString().equals("Piranha Plant")) {
            monologue.add("Slsstssthshs~! (Never gonna say goodbye~)");
            monologue.add("Ohmnom nom nom nom.");
            retString = monologue.get(selectRandomNum(0, monologue.size() - 1));
        }

        return actor.toString() + ": \"" + retString + "\"";
    }

    /**
     * Description
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Wanna hear something?";
    }

    /**
     * Select a random quote
     * @param min
     * @param max
     * @return
     */
    public int selectRandomNum(int min, int max){
        // prints a random number between min and max value
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

}
