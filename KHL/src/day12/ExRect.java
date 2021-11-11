package day12;

public class ExRect extends ExShape{
	
	final int side = 4;
	
	public ExRect(int x1, int x2, int y1, int y2)
	{
		super(x1, x2, y1, y2);
	}
	
	@Override
	public void print()
	{
		System.out.println("----- 사각형 -----");
		System.out.println("시작점 : ("+ startX +"," + startY +")");
		System.out.println("끝점 : ("+ endX +"," + endY +")");
		System.out.println("가로 : " + getWidth());
		System.out.println("세로 : " + getHeight());
	}
	
	public void testR()
	{
		System.out.println("사각형");
	}
}
