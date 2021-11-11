package day12;

public class ExaTextEx2 {

	public static void main(String[] args) {
		// 사각형과 타원을 여러개 저장할 수 있는 배열 생성
		
		ExShape shape[] = new ExShape[10];
		shape[0] = new ExShape(0, 0, 10, 10);
		shape[1] = new ExRect(20, 20, 30, 30);
		shape[2] = new ExEllipse(40, 40, 50, 50);
		shape[3] = new ExEllipse(20, 20, 50, 50);
		shape[4] = new ExRect(0, 10, 30, 30);
				
		for(int i = 0; i < shape.length ; i++)
		{
			if(shape[i] != null)
			{	
				shape[i].print();
				if(shape[i] instanceof ExRect)
				{	
					((ExRect)shape[i]).testR();
					print(((ExRect)shape[i]));
				}
				else if(shape[i] instanceof ExEllipse)
				{
					((ExEllipse)shape[i]).testE();
					print(shape[i]);
				}
				
			}
		}
		
	}
	
	public static void print(ExShape shape)
	{
		System.out.println("도형");
	}
	public static void print(ExRect rect )
	{
		System.out.println("사각형");
	}
	public static void print(ExEllipse ellipse)
	{
		System.out.println("타원");
	}
	


}
