package iwrap.util;


public class Ship {
	float length;//The length of the ship船长
	float width;//The width of the ship船宽
	float course;//The course of the ship航向
	float speed;//The speed of the ship航速
	ShipKind type;//The class of the ship船舶种类
	float quantityofShip;//The quantity of the ship through船舶流量
	Distribution dist;//The distribution of the kind of ship交通流分布
	
	public Ship(float length, float width, float course, float speed,
			ShipKind type, float quantityofShip, Distribution dist) {
		super();
		this.length = length;
		this.width = width;
		this.course = course;
		this.speed = speed;
		this.type = type;
		this.quantityofShip = quantityofShip;
		this.dist = dist;
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
	public float getCourse() {
		return course;
	}
	public void setCourse(float course) {
		this.course = course;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}	
	public ShipKind getType() {
		return type;
	}
	public void setType(ShipKind type) {
		this.type = type;
	}
	public float getQuantityofShip() {
		return quantityofShip;
	}
	public void setQuantityofShip(int quantityofShip) {
		this.quantityofShip = quantityofShip;
	}
	public Distribution getDist() {
		return dist;
	}
	public void setDist(Distribution dist) {
		this.dist = dist;
	}

	@Override
	public String toString() {
		return "Ship [length=" + length + ", width=" + width + ", course="
				+ course + ", speed=" + speed + ", type=" + type
				+ ", quantityofShip=" + quantityofShip + ", dist=" + dist
				+ "]";
	}
	
	//get the relative speed of the two ships求两船相对速度
	public static float getRelativeSpeed(Ship shipOne,Ship shipTwo,EncounterSituation es) {
		
		switch(es) {
		case headOn:
			return shipOne.speed + shipTwo.speed;
		case takeOver:
			if(shipOne.speed >= shipTwo.speed)
				return shipOne.speed - shipTwo.speed;
			else return shipTwo.speed - shipOne.speed;
		case cross:
			float angle;
			if(shipOne.course >= shipTwo.course)
				angle = shipOne.course - shipTwo.course;
			else angle = shipTwo.course - shipOne.course;
			//System.out.println("Angel"+shipOne.speed);
			return (float)Math.sqrt(shipOne.speed * shipOne.speed + shipTwo.speed * shipTwo.speed
					- 2 * shipOne.speed * shipTwo.speed * Math.cos(angle*2*Math.PI/360) );
		default: return 0;
		}
	}
	
	//get the counter situation between the two ships求得两船的相遇情况
	public static  EncounterSituation getCounterSituation(Ship shipOne, Ship shipTwo) {
		float angle;
		if(shipOne.course >= shipTwo.course) 
			angle = shipOne.course - shipTwo.course;
		else angle = shipTwo.course - shipOne.course;
		if(angle == 0)
			return EncounterSituation.takeOver;
		else if(angle == 180)
			return EncounterSituation.headOn;
		else 
			return EncounterSituation.cross;
	}
	
	//get the angle difference of the two ships
	public static float getAngleDifference(Ship shipOne, Ship shipTwo) {
		if(shipOne.course >= shipTwo.course){
			return shipOne.course - shipTwo.course;
		} else {
			return shipTwo.course - shipOne.course;
		}
	}
}
