package iwrap.util;

public class Channel {
	float length;//The length of the channel航道长度
	float width;//The width of the channel航道宽度
	
	public Channel(float length, float width) {
		super();
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

	
	@Override
	public String toString() {
		return "Channel [length=" + length + ", width=" + width + "]";
	}
	
}
