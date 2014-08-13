package iwrap.aground;

import iwrap.util.*;

public class FTwo {
	Distribution dist;//The distribution of the ships�ֲ�����
	Ship shipOne;//The kind of the ship��������
	Channel channel;//The bending channel of the case ������Ϣ
	
	public FTwo(Distribution dist, Ship shipOne, Channel channel) {
		this.dist = dist;
		this.shipOne = shipOne;
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "FTwo [dist=" + dist + ", shipOne=" + shipOne
				+ ", channel=" + channel + "]";
	}
	
	public float getFTwoValue() {
		dist.setMinIntegration(channel.getMinObstacle());
		dist.setMaxIntegration(channel.getMaxObstacle());
		float tempIntegration = dist.getIntegrationbyRectangle();
		double tempForgetCheckPosition = 
			Sailor.getProbabilityForgetCheckPosition(channel.getDistanceObstacle());
		return (float)(CausasionFactor.agroundFactor*shipOne.getQuantityofShip()*tempIntegration*tempForgetCheckPosition);
	}
}
