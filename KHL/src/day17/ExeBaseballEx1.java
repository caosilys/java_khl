package day17;

import java.util.*;

public class ExeBaseballEx1 {

	public static void main(String[] args) {

		List<Integer> quiz_ = new ArrayList<Integer>();
		
		// 문제생성
		GameManager gm = new GameManager(3, 9, 0);
		quiz_ = gm.getList();
		
		System.out.println("문제가 생성되었습니다");
		
//		System.out.println(quiz_.toString());
		// 정답입력
		Scanner scan = new Scanner(System.in);
		
		int anser[] = new int [3];
		
		Boolean game = true;
		while(game)
		{	
			System.out.println("숫자 3개를 입력세요");	
			
			for(int i = 0 ; i < quiz_.size() ; i++)
			{	
				anser[i] = scan.nextInt();
			}
		
			//오답시 표기방법		
			int strike = 0, ball =0;
			
			for(int i = 0; i < 3; i++)
			{
				for (int j = 0 ;  j < 3 ; j++)
				{
					if(quiz_.get(i) == anser[j] && i==j)
					{
						strike++;
					}
					else if(quiz_.get(i) == anser[j])
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

