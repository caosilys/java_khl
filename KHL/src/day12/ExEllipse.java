package day12;

public class ExEllipse extends ExShape{
	
	final int side = 0;
	
	public ExEllipse(int x1, int x2, int y1, int y2)
	{
		super(x1, x2, y1, y2);
	}
	
	@Override
	public void print()
	{
		System.out.println("----- 타 원 -----");
		System.out.println("시작점 : ("+ startX +"," + startY +")");
		System.out.println("끝점 : ("+ endX +"," + endY +")");
		System.out.println("너비 : " + getWidth());
		System.out.println("높이 : " + getHeight());
	}
	
	public void testE()
	{
		System.out.println("타원");
	}
}
