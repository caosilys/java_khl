package day01;

public class PrintEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = 10;
		int num2 = 20;
		char operater = '+';
		// 계획 10+20 = 30 으로 출력
		System.out.println(num1 + operater + num2 + "=" + num1 + num2);
		// 결과 73=1020 으로 출력됨
		// 정수 + 문자 => 정수
		// '+'의 아스키코드값 = 43 
		// 10 + 43 + 20 이 출력됨
		
		System.out.println(""+num1 + operater + num2 + "=" + num1 + num2);
		// 정수 + 문자열 => 문자열
		System.out.println(""+num1 + operater + num2 + "=" + (num1 + num2));
	}

}
