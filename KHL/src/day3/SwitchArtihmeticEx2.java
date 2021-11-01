package day3;

import java.util.Scanner;

public class SwitchArtihmeticEx2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("몇월??");
		int mounth;
		mounth = scan.nextInt();		
		
		switch (mounth) 
		{
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println(mounth +"월은 31일까지"); break;
		case 4, 6, 9, 11 :
			System.out.println(mounth +"월은 30일까지"); break;
		case '2': System.out.println(mounth +"월은 28일까지"); break;
		default: System.out.println("무얼 입력한게요...");
		}
		
		scan.close();
	}

}
