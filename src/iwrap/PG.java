package iwrap;
import iwrap.util.*;
public class PG {
	Ship shipOne, shipTwo;
	public PG(Ship shipOne, Ship shipTwo) {
		this.shipOne = shipOne;
		this.shipTwo = shipTwo;
	}
	
	public Ship getShipOne() {
		return shipOne;
	}
	public void setShipOne(Ship shipOne) {
		this.shipOne = shipOne;
	}
	public Ship getShipTwo() {
		return shipTwo;
	}
	public void setShipTwo(Ship shipTwo) {
		this.shipTwo = shipTwo;
	}

	public  float getPG() {		
		int dangerCount = 0;
		EncounterSituation es;
		
		es = Ship.getCounterSituation(shipOne, shipTwo);
		if(es == EncounterSituation.cross) return 0;
		
		//get PG valueµÃµ½PGÖµ
		for(int i = 0; i < 10000; i++) {
			if(Math.abs(shipOne.getDist().getDistribution() - shipTwo.getDist().getDistribution())
					<= (shipOne.getWidth()+shipTwo.getWidth())/2)
			dangerCount++;			
		}
		System.out.println("Class-PG="+dangerCount/10000.0f);
		return dangerCount/10000.0f;
	}
}
