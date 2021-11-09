package day08;
import java.util.Arrays;
import java.util.Scanner;

import day08.MethodRandomEx2;

public class LottoEx1 {

	public static void main(String[] args) {
		
		int [] lotto;
		// int bouns;
		
		// 1~45 중복되지 않은 번호 7개 생성
		lotto = day08.MethodRandomEx2.randomArray2(7, 1, 45);
		
		System.out.println("lotto 번호를 입력하세요");
		
		System.out.println("테스트용 : "+ Arrays.toString(lotto));
		
		// 6개 숫자 입력
		Scanner scan = new Scanner(System.in);
		int input[] = new int[6];
		for(int i = 0; i < 6 ; i++)
		{
			input[i]= scan.nextInt();
		}	
		
		// 당첨번호 출력		
		System.out.println("당첨번호 : "+ Arrays.toString(lotto));
		System.out.println("보너스 : " + lotto[6]);
		
		// 등수 출력
		message(check(lotto, input));
	}
	
	/**
	 * 입력값 / 출력값 비교
	 * @q 로또번호
	 * @a 입력번호
	 * @return 6->1등 12->2등 5->3등 4-> 4등 3->5등
	 *  */
	public static int check(int[] q, int[] a)
	{
		int score = 0;
		
		for(int i = 0 ; i < q.length-1 ; i++)
		{
			for(int j = 0 ; j < a.length ; j++)
			{
				if(q[i] == a[j])
				{
					score++;
				}
			}			
		}
		
		if(score==5)
		{
			for(int k = 0; k < a.length ; k++)
			{
				if(q[q.length-1]==a[k])
				{
					score += 7;
				}
			}
		}
		
		return score;
	}
	
	public static void message(int score)
	{
		switch (score) 
		{
			case 6 : System.out.println("1등이다!! 에레라디야~"); break;
			case 12 : System.out.println("2등이로구나~~~"); break;
			case 5 : System.out.println("3등~ 3등~"); break;
			case 4 : System.out.println("4~~~등~~~"); break;
			case 3 : System.out.println("5등이군요"); break;
			default: System.out.println("꽝입니다");
		}
	}
	

}
