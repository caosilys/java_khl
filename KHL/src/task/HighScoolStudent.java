package task;

public class HighScoolStudent {
		
	// 학교명
	public String scoolName;
	// 학년
	public int grade;
	// 반
	public int group;
	// 번호
	public int no;
	//이름
	public String name;
	
	/**
	 * @param scoolName : 학교명
	 * @param grade : 학년
	 * @param group : 반
	 * @param no : 번호
	 * @param name : 이름
	 */
	public HighScoolStudent(String scoolName, int grade, int group, int no, String name )
	{
		this.scoolName = scoolName;
		this.grade =  grade;
		this.group = group;
		this.no = no;
		this.name = name;
	}
	
	public void print()
	{
		System.out.println(toString());
	}
	
	@Override
	public String toString() 
	{
		return 
				scoolName + grade +"학년 " + group + "반 " +no + "번 " + name +"입니다.";

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HighScoolStudent hss = 
				new HighScoolStudent("그린고등학교", 1, 1, 1, "홍길동");
		
		hss.print();

	}
}
