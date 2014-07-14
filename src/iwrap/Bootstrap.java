package iwrap;
import iwrap.collision.Na;
import iwrap.util.*;
public class Bootstrap {

	public static void main(String[] args) {
		Distribution distOne = new Distribution(3f*100,150*150,1.0f*100,0.0f*100,0.0f,DistributionKind.normalDistribution);
		Distribution distTwo = new Distribution(3f*100,150*150,1.0f*100,6.0f*100,0.0f,DistributionKind.normalDistribution);
//		Distribution distTwo = new Distribution(3f*100,1.0f*100,150*150,6.0f*100,120.0f,DistributionKind.normalDistribution);
		Ship shipOne = new Ship(200f,33.2f,0f,14.7f*1852/3600.0f,ShipKind.tanker,10000f/(360*24*3600),distOne);
		Ship shipTwo = new Ship(200f,33.2f,88.8f,14.7f*1852/3600.0f,ShipKind.LNG,10000f/(360*24*3600),distTwo);
		Channel channel = new Channel(35046f,1200f);
		System.out.println("shipOne"+shipOne.toString());
		System.out.println("shipTwo"+shipTwo.toString());
		System.out.println("channel"+channel.toString());
		Na na = new Na(shipOne,shipTwo,channel);
		System.out.println("Na ="+na.getNa()*360*24*3600);
	}

}
