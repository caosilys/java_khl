package day10;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);		
		Board board = new Board(scan);		
		Boolean boardSwich = true;

		while(boardSwich)
		{	
			System.out.println();
			System.out.println("작업을 선택하세요.");
			System.out.println("1 : 목록보기");
			System.out.println("2 : 글 작성");
			System.out.println("3 : 조회");
			System.out.println("4 : 수정");
			System.out.println("5 : 삭제");
			System.out.println("6 : 종료");
			
			switch(scan.nextInt())
			{
				case 1 : // 목록보기
					board.showList();
					break;				
					
				case 2 : // 글 작성
					board.write();	
					break;
					
				case 3 : // 조회
					System.out.println("몇번 글을 보시겠습니까?");
					board.read(scan.nextInt());
					break;
					
				case 4 : // 수정
					System.out.println("몇번 글을 수정할까요?");
					int numR= scan.nextInt();
					board.revise(numR);
					break;
					
				case 5 : // 삭제
					System.out.println("몇번 글을 삭제할까요?");
					int numD = scan.nextInt();
					board.delete(numD);
					
					break;
					
				case 6 : // 종료
					boardSwich = false;
					System.out.println("종료합니다.");
					break;
					
				default : System.out.println("잘못 입력하셨어요");
			}
		}
		
		scan.close();

	}

}
