package iwrap;
import iwrap.aground.*;
import iwrap.util.*;
public class Bootstrap {

	public static void main(String[] args) {
//		Distribution distOne = new Distribution(0.0f*100,150*150,0.0f*100,3.0f*100,0.0f,DistributionKind.normalDistribution);
//		Distribution distTwo = new Distribution(0.0f*100,150*150,3.0f*100,6.0f*100,0.0f,DistributionKind.normalDistribution);
//		Distribution distTwo = new Distribution(3f*100,1.0f*100,150*150,6.0f*100,120.0f,DistributionKind.normalDistribution);
		//TakeOver
//		Ship shipOne = new Ship(214f,33.2f,0f,14.7f*1852/3600.0f,ShipKind.tanker,10000f/(360*24*3600),distOne);
//		Ship shipTwo = new Ship(162f,25f,0f,18.9f*1852/3600.0f,ShipKind.LNG,10000f/(360*24*3600),distTwo);
		//HeanOn
//		Ship shipOne = new Ship(214f,33.4f,0f,14.7f*1852/3600.0f,ShipKind.tanker,10000f/(360*24*3600),distOne);
//		Ship shipTwo = new Ship(214f,33.4f,180f,14.7f*1852/3600.0f,ShipKind.LNG,10000f/(360*24*3600),distTwo);
		//Cross
//		Ship shipOne = new Ship(200f,33.2f,0f,14.7f*1852/3600.0f,ShipKind.tanker,10000f/(360*24*3600),distOne);
//		Ship shipTwo = new Ship(200f,33.2f,88.8f,14.7f*1852/3600.0f,ShipKind.LNG,10000f/(360*24*3600),distTwo);
		//Test
//		Ship shipOne = new Ship(200f,33.2f,0f,14.7f*1852/3600.0f,ShipKind.tanker,10000f/(360*24*3600),distOne);
//		Ship shipTwo = new Ship(200f,33.2f,88.8f,14.7f*1852/3600.0f,ShipKind.LNG,10000f/(360*24*3600),distTwo);
//		Channel channel = new Channel(35046f,1200f);
//		System.out.println("shipOne"+shipOne.toString());
//		System.out.println("shipTwo"+shipTwo.toString());
//		System.out.println("channel"+channel.toString());
//		Na na = new Na(shipOne,shipTwo,channel);
//		for(int i = 0; i < 10; i++) {
//			System.out.println("Na ="+na.getNa()*360*24*3600);
//		}
		
		//Test ground demo
		Distribution distOne = new Distribution(3.0f*100,150*150,0.0f*100,12.0f*100,0.0f,DistributionKind.normalDistribution);
		Ship shipOne = new Ship(214f,33.2f,0f,14.7f*1852/3600.0f,ShipKind.tanker,10000f/(360*24*3600),distOne);
		BendingChannel bendingChannel = new BendingChannel(35046f,1200f,100f,1000f);
		
		FOne fOne = new FOne(distOne,shipOne,bendingChannel);
		FTwo fTwo = new FTwo(distOne,shipOne,bendingChannel);
		FDrifting fDrifting = new FDrifting(distOne,shipOne,bendingChannel);
		float tempDrifting = 0f;
		tempDrifting = fOne.getFOneValue()+fTwo.getFTwoValue()+fDrifting.getFDriftingValue();
		System.out.println("fOne.getFOneValue()= "+fOne.getFOneValue());
		System.out.println("fTwo.getFTwoValue()="+fTwo.getFTwoValue());
		System.out.println("fDrifting.getFDriftingValue()"+fDrifting.getFDriftingValue());
		System.out.println("DriftingValue = "+tempDrifting);
	}

}
