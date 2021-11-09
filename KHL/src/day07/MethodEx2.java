package day07;

public class MethodEx2 {

	public static void main(String[] args) {
		//  합을 출력하는 코드
		sumAll(1,11);
		System.out.println(gcd(16, 8));
		
	}
	
	public static void sumAll(int start, int end)
	{
		int sumall = 0;
		for(int i = start ; i <= end ; i++)
		{
			sumall +=i;
		}	
		System.out.println(sumall);
	}
	
	/**
	 * @num1 1번정수
	 * @num2 2번정수
	 * @return num1과 num2의 최대공약수*/
	public static int gcd (int num1, int num2)
	{
		 for(int i =num1 ; i > 0 ; i--)
		 {
			 if(num1%i==0 && num2%i==0)
			 {
				 		return i;
			 }
		 }
		 
		 return 0;
	}

}
