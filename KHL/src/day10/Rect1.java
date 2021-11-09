package day10;

public class Rect1 {
	
	int x;
	int y;
	int width;
	int height;

	public Rect1(int x, int y, int width, int height)
	{	
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void info()
	{	
		System.out.println("시작점 : (" + x + "," + y +")" );
		System.out.println("가로는 " + width + ", 세로는 " + height + "인 사각형");
	}
	
	public void move(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void resize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;	
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	

}
