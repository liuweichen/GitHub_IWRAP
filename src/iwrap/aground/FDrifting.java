package iwrap.aground;

import iwrap.util.CausasionFactor;
import iwrap.util.Channel;
import iwrap.util.Distribution;
import iwrap.util.Ship;
import iwrap.util.ShipKind;

public class FDrifting {
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
	//Get the probability of the ship in the danger �õ�������Σ�ո�ǳ����ĸ���
	public float getIntegrationValue() {
		dist.setWidthIntegration(channel.getWidthOrDistanceObstacle());
		float tempIntegration = dist.getIntegrationbyRectangle();
		return tempIntegration;
	}
	//Get the probability of ship out of control ����ʧ�صĸ���
	public float getProbabilityOutofControl() {
		float tempIndex;
		if(shipOne.getType()==ShipKind.passengerShip) {
			tempIndex = -(float)CausasionFactor.frequencyOutofControlDefault
					*channel.getLength()/shipOne.getSpeed();
			
		} else {
			tempIndex = (float)CausasionFactor.frequencyOutofControl
					*channel.getLength()/shipOne.getSpeed();
		}
		return (float)(1.0f - Math.exp(tempIndex));
	}
	//Get the integral of ship in no repair by speed drift from 1 to 3 ��Ư���ٶȵĻ���
	public float getProbabilityNoRepair() {
		float speedDriftMin = 1.0f;
		float speedDriftMax = 3.0f;
		int n = 1000;
		float step = (speedDriftMax - speedDriftMin)/n;
		float tempIntegral = 0.0f;
		for(int i = 0; i < n; i++) {
			tempIntegral += this.functionInNoRepair(speedDriftMin+i*step);
		}
		return tempIntegral*step;
	}
	//The function of ship in no repair ����û���޺õĸ��ʺ���
	public double functionInNoRepair(float speedDrift) {
		float timeGround = channel.getWidthOrDistanceObstacle()/speedDrift;
		return Math.exp(-1.05*Math.pow(timeGround, 0.9)) * 0.5;
	}
	
}