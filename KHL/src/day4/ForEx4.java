package day4;

public class ForEx4 {

	public static void main(String[] args) {
		/*두 정수의 최소 공배수*/
		
		int num1 = 3, num2 = 10;
		
		for(int i = 1 ; ; i++)
		{
			if(i%num1 == 0 && i%num2 ==0)
			{
				System.out.println("최소공배수 : " + i);
				break;
			}
		}
	}
}
