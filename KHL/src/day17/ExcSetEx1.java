package day17;

import java.util.*;

public class ExcSetEx1 {
	//Set -> 중복을 허용하지 않는 배열
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<Integer>();
		
		int min =0, max=9;
		
		while(set1.size() < 3)
		{
			int num = (int)(Math.random()*(max-min+1)+min);
			set1.add(num);
		}
		
		Iterator it = set1.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
		
	}

}
