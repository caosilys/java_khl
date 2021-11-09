package day03;

import java.util.Scanner;

public class IfArithmeticEx1 {

	public static void main(String[] args) {

		/* 두 정수와 산술연산자중 하나를 입력하여 입력한 연산가가+이면
		 * 두 정수의 합을 출력하는 코드를 작성하세요*/
		
		int num1, num2;
		char artiemetic;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자1을 입력하세요");
		num1 = scan.nextInt();
		System.out.println("숫자2를 입력하세요");
		num2 = scan.nextInt();
		System.out.println("연산자를 입력하세요");
		artiemetic = scan.next().charAt(0);
		if ('+' == artiemetic)
		{
			System.out.println(num1+num2);
		}
		else if('-' == artiemetic)
		{			
			System.out.println(num1-num2);
		}
		else if('*' == artiemetic)
		{
			System.out.println(num1*num2);
		}
		else if('/' == artiemetic)
		{
			System.out.println(num1/num2);
		}
		else
		{
			System.out.println("문제가... 있어.....?");
		}
		
		scan.close();
	}

}
