package iwrap.aground;

import iwrap.util.*;

public class FOne {
	Distribution dist;//The distribution of the ships分布函数
	Ship shipOne;//The kind of the ship船舶种类
	Channel channel;//The channel of the case航道信息
	
	public FOne(Distribution dist, Ship shipOne, Channel channel) {
		this.dist = dist;
		this.shipOne = shipOne;
		this.channel = channel;
	}
	
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
		dist.setMinIntegration(channel.getMinObstacle());
		dist.setMaxIntegration(channel.getMaxObstacle());
		float tempIntegration = dist.getIntegrationbyRectangle();
		//System.out.println(tempIntegration+"****");
		return (float)(CausasionFactor.agroundFactor*shipOne.getQuantityofShip()*tempIntegration);
	}
}
