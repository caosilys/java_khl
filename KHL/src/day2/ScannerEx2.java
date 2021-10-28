package day2;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) throws InterruptedException {
		/*두 정수를 입력받아 입력받은 정수들의 합을 구하는 코드를 작성하기*/
		
		int num1, num2;
		Scanner scan = new Scanner(System.in);
		num1 = scan.nextInt();
		System.out.println("num1 : " + num1 );
		num2 = scan.nextInt();
		System.out.println("num2 : " + num2 );
		Thread.sleep(1000);
		System.out.println("더하기 : "+ (num1+num2));
		System.out.println("나누기 : "+ ((double)num1 / num2));
		scan.close();

	}

}