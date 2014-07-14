package iwrap.collision;
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
		System.out.println("SpeedRR="+Ship.getRelativeSpeed(shipOne, shipTwo, es));
		//get PG value得到PG值,i最小为100000不然不稳定
		for(int i = 0; i < 100000; i++) {
			if(Math.abs(shipOne.getDist().getDistribution() - shipTwo.getDist().getDistribution())
					<= (shipOne.getWidth()+shipTwo.getWidth())/2)
			dangerCount++;
//			if(i < 1000) {
//				System.out.println("dangerCount="+shipOne.getDist().getDistribution());
//				System.out.println("dangerCount="+shipTwo.getDist().getDistribution());
//				System.out.println("="+Math.abs(shipOne.getDist().getDistribution() - shipTwo.getDist().getDistribution()));
//				System.out.println("b="+(shipOne.getWidth()+shipTwo.getWidth())/2);
//				
//			}
		}
		//System.out.println("Class-PG="+dangerCount/10000.0f);
		return dangerCount/100000.0f;
	}
}
