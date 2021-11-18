package day06;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballEx {

	public static void main(String[] args) {
		
		// 문제 생성
		int question[] = new int[3];
		for(int i = 0 ; i < question.length ; i++)
		{
			question[i] = (int)(Math.random()*10);
		// 중복방지
			for(int j = 1 ; j <= i ; j++)
			{
				if(question[i] == question[i-j])
				{
					i--;
				}
			}
		}
		
//		System.out.println(Arrays.toString(question)); // 정답체크	
		System.out.println("문제가 생성되었습니다");

		// 정답입력
		Scanner scan = new Scanner(System.in);
		int anser[] = new int [3];
		
		Boolean game = true;
		while(game)
		{	
			System.out.println("숫자 3개를 입력세요");	
			for(int i = 0 ; i<question.length ; i++)
			{	
				anser[i] = scan.nextInt();
			}
		
			//오답시 표기방법		
			int strike = 0, ball =0;
			
			for(int i = 0; i < 3; i++)
			{
				for (int j = 0 ;  j < 3 ; j++)
				{
					if(question[i] == anser[j] && i==j)
					{
						strike++;
					}
					else if(question[i] == anser[j])
					{
						ball++;
					}
				}
			}
		
			// 정답 판별 및 오답시 메시지 출력
			if(strike == 3)
			{
				System.out.println("정답입니다");
				game = false;
			}
			else
			{
				System.out.println(strike + "S, " + ball +"B");
			}			
		}
		scan.close();		
	}
}
