package day12;

import java.util.Scanner;

public class Practice {
	
	// 그려진 도형버퍼
	public static ExShape[] shapes = new ExShape[10]; 
	
	// 쓰레기통 버퍼
	public static ExShape[] trash = new ExShape[10];

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 프로그램 반복플래그
		boolean flag = true;
		
		while(flag)
		{
			System.out.println("1. 도형그리기");
			System.out.println("2. 다시실행");
			System.out.println("3. 실행취소");
			System.out.println("4. 도형확인");
			System.out.println("5. 프로그램 종료");
			int num = scan.nextInt();
			switch(num)
			{
				case 1: drow(scan); break;
				case 2: reDrow(); break;
				case 3: cancel(); break;
				case 4: check(); break;
				case 5: flag = false; break;	
			}
		}
		scan.close();
	}
	
	// shape타입 객체를 shapes에 저장
	public static void input (ExShape shape)
	{	
		for(int i = 0; i < shapes.length ; i++)
		{
			if(shapes[i] == null)
			{
				shapes[i] = shape;
				trash = null;
				break;
			}
		}
	}
	
	// 입력을받아 입력에 따른 shape타입 객체 생성
	public static void drow(Scanner scan)
	{
		System.out.println("그릴 도형을 선택하세요. 1. 사각형 2. 타원");
		int input = scan.nextInt();
		System.out.println("점 두개를 입력하세요 (x1,x2), (y1,y2) ");
		int x1, x2, y1, y2;
		x1 = scan.nextInt();			x2 = scan.nextInt();
		y1 = scan.nextInt();			y2 = scan.nextInt();		
		if(input == 1)
		{
			ExRect rect = new ExRect(x1, x2, y1, y2);
			input(rect);
			System.out.println("사각형을 그렸다.");
		}
		else if(input == 2)
		{
			ExEllipse Ellipse = new ExEllipse(x1, x2, y1, y2);
			input(Ellipse);
			System.out.println("타원을 그렸다");
		}
		else
		{
			System.out.println("잘못된 입력입니다");
		}
		
	}
	
	// 쓰레기통버퍼에 마지막 객체를 도형 버퍼로 이동
	public static void reDrow()
	{
		for(int i = 0 ; i < trash.length ; i++)
		{
			if(trash[i] == null)
			{
				for(int j = 0 ; j < shapes.length; j++)
				{
					if(shapes[j] == null)
					{
						shapes[j] = trash[i-1];
						break;
					}
				}
				trash[i-1]= null;
			}
		}
		System.out.println("다시실행");
	}
	
	// 도형버퍼의 마지막 객체를 쓰레기통 버퍼로 이동
	public static void cancel()
	{
		for(int i = 0 ; i < shapes.length ; i++)
		{
			if(shapes[i] == null)
			{
				for(int j = 0 ; j < trash.length; j++)
				{
					if(trash[j] == null)
					{
						trash[j] = shapes[i-1];
						break;
					}
				}
				shapes[i-1]= null;
			}
		}
		System.out.println("실행취소");
	}
	
	// 도형버퍼에 있는 객체에 print() 메소드 실행
	public static void check()
	{
		for(int i = 0 ; i < shapes.length ; i++)
		{
			if(shapes[i]!=null)
			{
				shapes[i].print();
			}
			else
			{
				break;
			}
		}
	}
	
	
}
