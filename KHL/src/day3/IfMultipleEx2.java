package day3;

import java.util.Scanner;

public class IfMultipleEx2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println("정수를 입력하세요");
		
		num = scan.nextInt();
		
		if(num%6 == 0)
		{
			System.out.println("해당 수는 6의배수요");

		}
		else if(num%3 ==0)
		{
			System.out.println("해당 수는 3의배수요");
		}
		else if(num%2 ==0)
		{
			System.out.println("해당 수는 2의배수요");
		}
		else
		{
			System.out.println("이건 2의 배수도 3의배수도 6의배수도 아니군");
		}
		scan.close();
	}

}
