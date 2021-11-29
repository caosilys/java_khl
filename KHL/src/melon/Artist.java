package melon;

import java.util.*;

public class Artist {
	
	private int num;
	private String name;
	private int personnel;
	private char gender;
	private ArrayList<Artist> members;
	private String birth;
	private String team;
	private boolean group;
	
	// 솔로
	public Artist(int num, String name, int personnel, char gender, String birth, String team)
	{
		
	}
	
	// 그룹
	public Artist(int num, String name, int personnel, char gender, String birth, String team, Artist ...artist)
	{
		
	}
	
}
