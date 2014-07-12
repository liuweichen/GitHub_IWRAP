package iwrap;
import iwrap.util.*;
public class Bootstrap {

	public static void main(String[] args) {
		Distribution distOne = new Distribution(0.5f*100,1.0f*100,0.0f*100,1.0f*100,DistributionKind.normalDistribution);
		Distribution distTwo = new Distribution(1.0f*100,1.0f*100,0.5f*100,1.5f*100,DistributionKind.normalDistribution);
		Ship shipOne = new Ship(70f,20f,10f,5f,"Tanker",6,distOne);
		Ship shipTwo = new Ship(70f,20f,50f,6f,"LNG",6,distTwo);
		Channel channel = new Channel(2000f,150f);
		System.out.println("shipOne"+shipOne.toString());
		System.out.println("shipTwo"+shipTwo.toString());
		System.out.println("channel"+channel.toString());
		Na na = new Na(shipOne,shipTwo,channel);
		System.out.println("Na ="+na.getNa());
	}

}
