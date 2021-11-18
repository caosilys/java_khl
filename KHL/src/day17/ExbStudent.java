package day17;

import java.util.ArrayList;

public class ExbStudent {
	
	private int grade, classNum, num;
	private String name;
	private ArrayList<ExbScore> score;
	
	public ExbStudent(int grade, int classNum, int num, String name)
	{
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ExbStudent [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + ", score="
				+ score + "]";
	}
	
	
}
