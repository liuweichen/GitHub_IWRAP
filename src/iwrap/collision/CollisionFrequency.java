package iwrap.collision;

import iwrap.util.*;

public class CollisionFrequency {
	Na na;
	
	public CollisionFrequency(Na na) {
		this.na = na;
	}
	
	EncounterSituation es = Ship.getCounterSituation(na.shipOne,na.shipTwo);
	public float getCollisionFrequency() {
		switch(es) {
		case cross:
			return (float)(na.getNa()*CausasionFactor.crossCollision);
		case headOn:
			return (float)(na.getNa()*CausasionFactor.headOnCollision);
		case takeOver:
			return (float)(na.getNa()*CausasionFactor.overtakeCollision);
		default:
			return 0.0f;
		}
	}
	
}
