package game.highgrounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.JumpAction;

public class Wall extends HighGround {

	public Wall() {
		super('#');
	}


	public int jumpSuccessChance = 80;
	public int jumpFailureDamage = 20;

	public int getJumpSuccessChance() {
		return jumpSuccessChance;
	}

	public int getJumpFailureDamage() {
		return jumpFailureDamage;
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.STARPOWERED);
	}

	@Override
	public ActionList allowableActions(Actor actor, Location location, String direction) {
		ActionList actions = new ActionList();
		actions.add(new JumpAction(location, direction));
		return actions;
	}

	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
