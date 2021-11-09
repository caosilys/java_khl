package day07;

public class MethodEx1 {
	

	public static void main(String[] args) {
		
		System.out.println(sum(2, 3));
		sum2(3,7);
	}
	
	/*
	 * 기능 : 두 정수의 합을 알려주는 메소드
	 * 매개변수 ㅣ 두 정수 => int num1, int num2
	 * */
	public static int sum (int num1, int num2)
	{
		return num1+num2;
	}
	
	public static void sum2(int num1, int num2)
	{
		System.out.println(num1+num2);
	}
	


}
