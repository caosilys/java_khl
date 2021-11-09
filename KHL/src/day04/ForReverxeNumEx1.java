package day04;

import java.util.Iterator;
import java.util.Scanner;

public class ForReverxeNumEx1 {

	public static void main(String[] args) {
		
		 for(int i = 5 ; i > 0 ; i--)
		 {
			 System.out.println(i);
		 }
		 
		 /* 최대공약수 */
		 System.out.println("최대공약수 출력");
		 int num1 =88, num2 =12;	 
		 for(int i =num1 ; i > 0 ; i--)
		 {
			 if(num1%i==0 && num2%i==0)
			 {
				 		System.out.println(i);
				 		break;
			 }
		 }
		 
		 
		 Scanner scan = new Scanner(System.in);
		 System.out.println("소수 판별");
		 int num3 = scan.nextInt();
		 
		 int count=0;
		 for(int i = 1 ; i <= num3 ; i++)
		 {	
			if(num3%i ==0)
			{
				count++;
			}
		 }
		 
		 if(count == 2)
		 {
			 System.out.println("소수");
		 }
		 else
		 {
			 System.out.println("소수아님");
		 }
		 scan.close();
		 

	
	}

}
