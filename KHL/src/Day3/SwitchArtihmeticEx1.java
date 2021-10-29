package Day3;

import java.util.Scanner;

public class SwitchArtihmeticEx1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num1, num2;
		char cha;
		System.out.println("계산식을 입력하세요");
		
		num1 = scan.nextInt();
		cha = scan.next().charAt(0);
		num2 = scan.nextInt();
		
		switch (cha) 
		{
		case '+': System.out.println(num1+num2); break;
		case '-': System.out.println(num1-num2); break;
		case '*': System.out.println(num1*num2); break;
		case '/': System.out.println((double)num1/num2); break;
		default: System.out.println("잘못된연산자");
		}
		
		scan.close();
	}

}
