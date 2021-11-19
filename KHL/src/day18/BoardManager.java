package day18;

import java.util.*;

public class BoardManager {
	
	List <Board> list;
	Scanner scan;
	
	// 게시글 no로 게시글 index 확인, 해당글 없을시 -1 리턴
	public int checkBoard(int no)
	{
		Iterator<Board> it = list.iterator(); 
		while(it.hasNext())
		{
			Board tmp = it.next();
			if(tmp.getNo() == no)
			{
				return list.indexOf(tmp);
			}			
		}
		
		System.out.println("해당 게시글이 없습니다");
		return -1;
	}
	
	// 비밀번호 확인.
	public Boolean checkPassword(int no, int index)
	{	
		System.out.println("password를 입력하세요");
		String pw = scan.nextLine();
		Board tmp = new Board(no, pw);
		Board getTmp = list.get(index);		
		Boolean bool =  getTmp.equals(tmp);
		if(!bool)
		{
			System.out.println("패스워드가 다릅니다");
		}
		return bool;	
	}
	
	// 글쓰기
	// 등록시에는 list 확인후 no값을 넘겨줌
	// 수정시에는 기존 no 값, id, pw 유지
	public Board createBoard(int no, Boolean newBoard)
	{	
		// 입력받을 내용 : id, pw, title, content
		Board board;
		String id, pw, title, content;
		if(newBoard)
		{
			System.out.println("이름을 입력해주세요");
			id = scan.nextLine();
			System.out.println("비밀번호를 입력해주세요");
			pw = scan.nextLine();
		}
		else
		{
			id = list.get(checkBoard(no)).getId();
			pw = list.get(checkBoard(no)).getPw(1357);
		}
		
		System.out.println("제목을 입력해주세요");
		title = scan.nextLine();
		System.out.println("내용을 입력해주세요");
		content = scan.nextLine();
		
		board = new Board(no, title, id, pw, content);		
		return board;
	}
		
	// list를 확인하여 no값 지정후 쓴 글을 게시판에 저장
	public void addBoard()
	{	
		// 생성할 내용 : no -> size-1 객체의 no+1
		
		int no;		
		if(list.size() != 0)
		{
			no = list.get(list.size()-1).getNo() +1;
		}
		else
		{
			no = 1;
		}
		
		list.add(createBoard(no, true));
		System.out.println("게시글이 등록되었습니다");
	}
	
	// 글 목록 보기
	public void checkList()
	{
		Iterator<Board>it = list.iterator();
		if(list.size() == 0)
		{
			System.out.println("게시글이 없습니다");
		}

		while(it.hasNext())
		{
			Board temp = it.next();
			System.out.println(temp.viewName());
		}		
	}
	
	// 게시글 내용 보기
	public void readBoard()
	{
		System.out.println("확인할 게시글을 선택하세요");
		int no = scan.nextInt();
		scan.nextLine();
		int index = checkBoard(no);
		if(index != -1)
		{	
			System.out.println(list.get(index).viewContent());
		}		
	}
	
	// 글 수정
	public void updateBoard()
	{	
		//입력받을 내용 1. 글번호 2.id,pw
		System.out.println("수정할 게시글을 선택하세요");
		int no = scan.nextInt();
		scan.nextLine();
		int index = checkBoard(no);
		if(index != -1)
		{			
			if(checkPassword(no, index))
			{
				System.out.println("게시글을 수정합니다.");
				list.set(index, createBoard(no, false));
			}
		}		
	}
	
	// 글 삭제
	public void delateBorad()
	{
		System.out.println("삭제할 게시글을 선택하세요");
		int no = scan.nextInt();
		scan.nextLine();
		int index = checkBoard(no);
		if(index != -1)
		{	
			if(checkPassword(no, index))
			{
				list.remove(index);
				System.out.println("삭제되었습니다.");
			}

		}
	}
	
	//생성자
	public BoardManager(Scanner scan)
	{
		list = new ArrayList<Board>();
		this.scan = scan;
	}
}
