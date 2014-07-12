package iwrap.util;

public class Channel {
	float length;//The length of the channel航道长度
	float width;//The width of the channel航道宽度
	float widthObstacle = 0f;//The width of the obstacle障碍物宽度
	
	public Channel(float length, float width, float widthObstacle) {
		this.length = length;
		this.width = width;
		this.widthObstacle = widthObstacle;
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
	public float getWidthObstacle() {
		return widthObstacle;
	}
	public void setWidthObstacle(float widthObstacle) {
		this.widthObstacle = widthObstacle;
	}

	@Override
	public String toString() {
		return "Channel [length=" + length + ", width=" + width
				+ ", widthObstacle=" + widthObstacle + "]";
	}
	
}
