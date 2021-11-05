package day8;

import java.util.Arrays;
import java.util.Random;

public class MethodRandomEx2 {

	public static void main(String[] args) {
		// 
		int rotto[] = new int[6];
		
		for(int i = 0 ; i < rotto.length ; i++)
		{
			rotto[i] = intRandom(1, 45);

			
			for(int j = 1 ; j <= i ; j++)
			{
				if(rotto[i] == rotto[i-j])
				{
					i--;
				}
			}			
		}		
		System.out.println(Arrays.toString(rotto));
		
		System.out.println(Arrays.toString(randomArray2(6, 1, 45)));
		
	}
	
	/** 
	 * @arrays 저장하고자 하는 배열 (중복 비허용)
	 * @min 배열에 들어갈수있는 최소값
	 * @max 배열에 들어갈수있는 최대값
	 * */
	public static void ramdomArray1 (int[] arrays, int min, int max)
	{
		for(int i = 0 ; i < arrays.length ; i++)
		{
			arrays[i] = intRandom(min, max);
		
			for(int j = 1 ; j <= i ; j++)
			{
				if(arrays[i] == arrays[i-j])
				{
					i--;
				}
			}			
		}
	}
	
	/**
	 * @length 만들고자하는 배열의 길이
	 * @min 배열에 들어갈수 있는 최소값
	 * @max 배열에 들어갈수 있는 최대값
	 * @return min~max사이의 랜덤한 수가 들어가있는 배열
	 */
	public static int[] randomArray2 (int length, int min, int max)
	{
		int[] intArray = new int[length];
		ramdomArray1(intArray, min, max);	
		return intArray;
	}
	
	
	public static int intRandom(int min, int max)
	{
		Random r = new Random();		
		return r.nextInt(max-min+1)+min;
		
	}
}
