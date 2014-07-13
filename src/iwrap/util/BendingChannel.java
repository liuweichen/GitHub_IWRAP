package iwrap.util;

public class BendingChannel extends Channel {
	public float distanceToObstacle;
	
	public BendingChannel(float length, float width, float widthObstacle) {
		super(length, width, widthObstacle);
	}
	public BendingChannel(float length, float width) {
		super(length, width);
	}
	public BendingChannel(float length, float width, float widthObstacle,
			float distanceToObstacle) {
		super(length, width, widthObstacle);
		this.distanceToObstacle = distanceToObstacle;
	}
	
	public float getDistanceToObstacle() {
		return distanceToObstacle;
	}
	public void setDistanceToObstacle(float distanceToObstacle) {
		this.distanceToObstacle = distanceToObstacle;
	}
	
	@Override
	public String toString() {
		return "BendingChannel [distanceToObstacle=" + distanceToObstacle + "]";
	}

}
