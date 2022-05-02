package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

public class Wall extends Ground {

	public Wall() {
		super('#');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.STARPOWERED);
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
