package iwrap.aground;

import iwrap.util.*;

public class FTwo {
	Distribution dist;//The distribution of the ships�ֲ�����
	Ship shipOne;//The kind of the ship��������
	BendingChannel bendingChannel;//The bending channel of the case ������Ϣ
	
	public FTwo(Distribution dist, Ship shipOne, BendingChannel bendingChannel) {
		this.dist = dist;
		this.shipOne = shipOne;
		this.bendingChannel = bendingChannel;
	}

	@Override
	public String toString() {
		return "FTwo [dist=" + dist + ", shipOne=" + shipOne
				+ ", bendingChannel=" + bendingChannel + "]";
	}
	
	public float getFTwoValue() {
		dist.setWidthIntegration(bendingChannel.getWidthObstacle());
		float tempIntegration = dist.getIntegrationbyRectangle();
		double tempForgetCheckPosition = 
			Sailor.getProbabilityForgetCheckPosition(bendingChannel.getDistanceToObstacle());
		return (float)(CausasionFactor.agroundFactor*shipOne.getQuantityofShip()*tempIntegration*tempForgetCheckPosition);
	}
}
