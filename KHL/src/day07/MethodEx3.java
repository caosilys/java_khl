package day07;

import java.util.Arrays;

public class MethodEx3 {

	public static void main(String[] args) {
		/* 참조변수를 매개변수로 설정하면 원본이 바뀜		 * */
		int test[] = {1, 2, 3, 4};
		
		System.out.println(Arrays.toString(test));
		
		trans(test);
		
		System.out.println(Arrays.toString(test));
		
	}
	
	public static void trans(int[] nomal)
	{
		for(int i = 0 ; i < nomal.length ; i++)
		{
			nomal[i] = 0;
		}
	}

}
