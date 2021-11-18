package day17;

import java.util.*;

public class GameManager {
	// 난수생성 / 중복되지 않은 난수 생성/ 난수 범위지정가능
	
	private Set<Integer> set;
	private ArrayList<Integer> list;
	// 생성할 난수의 개수
	private int size;
	// 생성할 난수의 최대값
	private int max;
	// 생성할 난수의 최소값
	private int min;
	
	public GameManager(int size, int max, int min) {

		this.size = size;
		if(max < min)
		{
			this.max = min;
			this.min = max;
		}
		else
		{
			this.max = max;
			this.min = min;
		}
		set = new HashSet<Integer>();
		list = new ArrayList<Integer>();
		while(set.size() < size)
		{
			int num = (int)(Math.random()*(max-min+1)+min);
			if(set.add(num))
				{
					list.add(num);
				};
		}

	}
	
	public List getList()
	{
		return list;
	}
}
