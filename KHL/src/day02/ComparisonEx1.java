package day02;

public class ComparisonEx1 {
	
	public static void main (String[] args) {
		
		int age = 20;
		boolean isAdult = age >= 19;		
		System.out.println(age +"살은 성인인가? " + isAdult );
		
		int num1 =10;
		
		boolean isEven = num1 % 2 == 0;
		
//		if( num1%2 == 0)
//		{
//			isEven =true;
//		}
//		else
//		{
//			isEven = false;
//		}
				
		System.out.println(num1+ "은 짝수인가? " + isEven);
		
	}
}
