package day02;

public class LogEx1 {

	public static void main(String[] args) {
		//&&연산자 예제, A학점 판별을 이용
		int score = 95;
		boolean isA = score <= 100 && score >= 90;
		System.out.println(score + "점은 A학점인가? " + isA);
		
		boolean license = true, registrationCard = false;
		
		boolean testOk = license || registrationCard;
		System.out.println("시험응시 가능? " + testOk);
		
		
		
	}

}
