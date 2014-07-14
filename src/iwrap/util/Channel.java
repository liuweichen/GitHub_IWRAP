package iwrap.util;

public class Channel {
	float length;//The length of the channel��������
	float width;//The width of the channel�������
	float widthOrDistanceObstacle = 0f;//The width or the distance of the obstacle�ϰ����Ȼ��߾���
	
	public Channel(float length, float width, float widthOrDistanceObstacle) {
		this.length = length;
		this.width = width;
		this.widthOrDistanceObstacle = widthOrDistanceObstacle;
	}

	public Channel(float length, float width) {
		this.length = length;
		this.width = width;
	}
	
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getWidthOrDistanceObstacle() {
		return widthOrDistanceObstacle;
	}
	public void setWidthOrDistanceObstacle(float widthOrDistanceObstacle) {
		this.widthOrDistanceObstacle = widthOrDistanceObstacle;
	}

	@Override
	public String toString() {
		return "Channel [length=" + length + ", width=" + width
				+ ", widthOrDistanceObstacle=" + widthOrDistanceObstacle + "]";
	}
	
}
