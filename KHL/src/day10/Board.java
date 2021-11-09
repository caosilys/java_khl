package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
	
	private List<Post> list;
	private Scanner scan;
	
	public Board(Scanner scan) 
	{	
		this.scan = scan;
		list = new ArrayList<Post>();
		// 미리 게시글이 있음
		write("cao", "123", "공지사항", "그런거 없다");
		write("cao", "123", "안녕하세요?", "난 안녕못해요");
	}
	
	
	
	public void showList()
	{
		if(list.size()==0)
		{
			System.out.println("게시글이 없습니다");
		}
		
		for(int i = 0 ; i < list.size() ; i++)
		{
			Post showpost = list.get(i);
			System.out.println(i + " : "+ showpost.title);
		}
	}
	
	public void read(int contentNum)
	{	
		if(list.get(contentNum) != null)
		{
			Post post = list.get(contentNum);
			System.out.println("제목 : " + post.title);
			System.out.println("내용");
			System.out.println(post.content);
		}
		else
		{
			System.out.println("해당게시물은 없습니다.");
		}
	}
		
	public void write()
	{
		String id, pw, title, content;
		scan.nextLine();	
		System.out.println("id 입력");
		id = scan.nextLine();
		System.out.println("pw 입력");
		pw = scan.nextLine();
		System.out.println("title 입력");
		title = scan.nextLine();
		System.out.println("content 입력");
		content = scan.nextLine();
		
		Post post = new Post(id, pw, title, content);	
		list.add(post);
		
		System.out.println("게시글 생성");		
	}
	
	public void write(String id, String pw, String title, String content)
	{
		Post post = new Post(id, pw, title, content);	
		list.add(post);
	}
	
	public void revise(int contentNum)
	{	
		Post post = list.get(contentNum);
		if(checkPw(post))
		{	
			String title, content;
			System.out.println("title 입력");
			title = scan.nextLine();
			System.out.println("content 입력");
			content = scan.nextLine();
			
			post.title = title;
			post.content = content;
			System.out.println("수정되었어요");
		}
	}
		
	public void delete(int contentNum)
	{	
		
		if(list.size() <= contentNum || list.get(contentNum)==null)
		{
			System.out.println("존재하지 않는 게시물입니다");
		}
		else
		{		
				Post post = list.get(contentNum);
				if(checkPw(post))
				{
					list.remove(contentNum);
				}
		}	
	}
	
	public boolean checkPw(Post post)
	{	
		System.out.println("비밀번호를 입력하세요");
		scan.nextLine();
		String pw = scan.nextLine();
		
		if(post.pw.equals(pw))
		{
			return true;
		}
		else
		{	
			System.out.println("pw 불일치");
			return false;
		}
		
	}	
	

}
