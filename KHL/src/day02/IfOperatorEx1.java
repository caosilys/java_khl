package day02;

public class IfOperatorEx1 {

	public static void main (String[] args) {
		
		int score = 85;
		char isA = score <= 100 && score >= 90 ? 'Y' : 'N';
		
		System.out.println(isA);
		
		// num1 이 홀수이면 y 짝수이면 n을 출력
		int num1 =10;
		String isOdd = num1%2 == 1 ? "Yes" : "no";
		
		System.out.println(num1 + "은 홀수인가요? " + isOdd);
	}
}
