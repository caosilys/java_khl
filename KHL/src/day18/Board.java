package day18;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	
	private int no; // 글 번호
	private String title; // 글 제목
	private String id; // 작성자
	private String password; // 비밀번호
	private String content; // 글 내용
	private Date date;// 작성일 / 수정일
	
	
	public Board(int no, String title, String id, String passward, String content) {
		this.no = no;
		this.title = title;
		this.id = id;
		this.password = passward;
		this.content = content;
		this.date = new Date();
	}
	
	public Board(int no, String pw)
	{		
		this.no = no;
		this.password = pw;
	}
	
	public String viewName()
	{
		String name = 
				no + 
				"  제목 : " + title
				+ "\t\t작성자 : " + id
				+ "\t" + this.getDate();
		
		return name;
	}
	
	public String viewContent()
	{
		String content =
				viewName()
				+ "\n"
				+ this.content;
		return content;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (no != other.no)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	public String getPw(int password)
	{
		if(password == 1357)
		{
			return this.password;
		}
		return "password error";
	}
	public String getDate()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strdate = format.format(date);
	
		return strdate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
