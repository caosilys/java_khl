package day06;

import java.util.Scanner;

public class ArrayEx2 {

	public static void main(String[] args) {
		// 
		
		Scanner scan = new Scanner(System.in);
		
		int ko[] = new int[5];
		int sum=0; 
		double avg = 0;
		for(int i = 0 ; i < 5 ; i++)
		{
			System.out.println(i+1 + "의 성적 입력");
			ko[i] = scan.nextInt();
			sum += ko[i];
		}
		avg = (double)(sum/5.0);
		
		System.out.println("평균 : " + avg);
		
		scan.close();
		
	}

}
