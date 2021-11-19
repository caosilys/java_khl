package day18;

import java.util.*;
public class ExfBoardEx1 {

	public static void main(String[] args) {
		// 게시글 관리 프로그램
		// 리스트 사용
		// 1. 게시글 등록, 2. 게시글확인 확인(전체)
		// 3. 게시글 수정, 4. 게시글 삭제
		// 5. 프로그램 종료
		
		Scanner scan = new Scanner(System.in);
		BoardManager bm = new BoardManager(scan);
		
		bm.list.add(new Board(1, "으~나가왔다!", "은하", "123", "안녕~~"));
		bm.list.add(new Board(2, "무지두 왔당~", "엄지", "123", "나도 안녕~~"));
		bm.list.add(new Board(3, "신비도 옴", "신비", "123", "ㅇㅇ"));
		
		Boolean flag = true;
		while(flag) 
		{	
			System.out.println();
			System.out.println("1. 게시글 목록");
			System.out.println("2. 게시글 등록");
			System.out.println("3. 게시글 확인");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("5. 프로그램 종료");
			int num = scan.nextInt();
			scan.nextLine();
			switch(num)
			{	
				case 1: bm.checkList(); break;
				case 2: bm.addBoard(); break;
				case 3: bm.readBoard(); break;
				case 4: bm.updateBoard(); break;
				case 5: bm.delateBorad(); break;
				case 6: System.out.println("프로그램 종료"); flag = false; break;
				
			}
		}	

	}

}
