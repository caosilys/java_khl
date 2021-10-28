package day2;

import java.util.Scanner;

public class ScannerEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println(num1);
		
		System.out.print("문자를 입력하세요 : ");
		char ch1 = scan.next().charAt(0);
		System.out.println(ch1);
		
		// 공백을 제외한 한 단어를 읽어옴
		System.out.print("문자열을 입력하세요 : ");
		String str1 = scan.next();
		System.out.println(str1);
		
		// 공백을 제외한 한 단어를 읽어옴
		System.out.print("문자열을 입력하세요 : ");
		String str2 = scan.nextLine();
		System.out.println(str2);
		
				
		scan.close();
		
	}
}
