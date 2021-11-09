package day03;

import java.util.Scanner;

public class IfMultipleEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num;
		
		System.out.println("정수를 입력하세요");
		
		num = scan.nextInt();
		
		if(num%2 == 0)
		{
			System.out.println("해당 수는 2의배수요");
		}
		else 
		{
			System.out.println("2의배수가 아닌가보오");
		}
		scan.close();
	}

}
