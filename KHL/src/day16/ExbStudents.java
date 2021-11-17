package day16;

public class ExbStudents {
	
	public ExbStudents(String name)
	{
		this.name = name;
		korean = 0;
		math = 0;
		english = 0;
	}
	
	public ExbStudents(String name, int korean, int math, int english)
	{
		this.name = name;
		this.korean = korean;
		this.math = math;
	}
	
	public ExbStudents(int code)
	{	
//		name = "";
//		korean = 0;
//		math = 0;
//		english =0;
		this.code = code;
	}

	public ExbStudents(String name, int korean, int math, int english, int code)
	{
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
		this.code = code;
	}
	private String name;
	private int code;
	private int korean;
	private int math;
	private int english;
	
	@Override
	public String toString()
	{
		return	 "이름 : " + name +
				 "\n국어 : " + korean +
				 "\n수학 : " + math +
				 "\n영어 : " + english ;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
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
		ExbStudents other = (ExbStudents) obj;
		if (code != other.code)
			return false;
		return true;
	}
	
	
	
}
