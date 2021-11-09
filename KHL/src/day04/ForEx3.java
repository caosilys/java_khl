package day04;

import java.util.Scanner;

public class ForEx3 {

	public static void main(String[] args) {
		/*1~i 까지의 합*/
		int sum = 0;
		for(int i = 1; i <11 ; i++)
		{
			sum += i;
		}
		System.out.println(sum);
		
		
		/*0일때까지 정수를 입력받는 코드*/
		Scanner scan = new Scanner(System.in);
		
		int i = 1;	
		
		while (i!=0)//for(;i!=0 ;)
		{
			System.out.println("정수를 입력하세요");		
			i = scan.nextInt();
			System.out.println(i);			
		}
		
		System.out.println("종료합니다");
		
		scan.close();
	}

}
