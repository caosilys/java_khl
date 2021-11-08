package day9;

public class ClassEx1 {
	
		
}
class Point2D{
	int x,y;
	
	public Point2D() {
		x=0; y=0;
	}
	
	Point2D(int x1, int y1)
	{
		x = x1; y = y1;
	}
	
	
}

class Car
{
	String brand;
	String type;
	int count;
	int power;
	int speed;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	void turnOn()
	{
		System.out.println("시동킴");
	}
	
	void turnOff()
	{
		System.out.println("시동끔");
	}
}
