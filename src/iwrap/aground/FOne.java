package iwrap.aground;

import iwrap.util.*;

public class FOne {
	Distribution dist;//The distribution of the ships�ֲ�����
	Ship shipOne;//The kind of the ship��������
	Channel channel;//The channel of the case������Ϣ
	
	public Distribution getDist() {
		return dist;
	}
	public void setDist(Distribution dist) {
		this.dist = dist;
	}
	public Ship getShipOne() {
		return shipOne;
	}
	public void setShipOne(Ship shipOne) {
		this.shipOne = shipOne;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	@Override
	public String toString() {
		return "FOne [dist=" + dist + ", shipOne=" + shipOne + ", channel="
				+ channel + "]";
	}
	
	public float getFOneValue() {
		dist.setWidthIntegration(channel.getWidthOrDistanceObstacle());
		float tempIntegration = dist.getIntegrationbyRectangle();
		return (float)(CausasionFactor.agroundFactor*shipOne.getQuantityofShip()*tempIntegration);
	}
}
