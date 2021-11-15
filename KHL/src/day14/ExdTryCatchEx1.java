package day14;

public class ExdTryCatchEx1 {

	public static void main(String[] args) {
//		try 
//		{
//			int res = 1 / 0;
//		} catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
		
		calcul(5, 0, '/');
		
		
		
	}
	
	public static void calcul(int x, int y, char ac)
	{
		switch(ac)
		{
		case '+' : System.out.println(x+y); break;
		case '-' : System.out.println(x-y); break;
		case '*' : System.out.println(x*y); break;
		case '/' : 
			try
			{
				System.out.println(x/y);
			}
			catch (ArithmeticException e) {
				System.out.println("0으로는 나눌수 없습니다.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
			break;
		}
	}

}
