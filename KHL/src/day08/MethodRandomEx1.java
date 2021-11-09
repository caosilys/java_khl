package day08;

import java.util.Random;

public class MethodRandomEx1 {

	public static void main(String[] args) {
		// 
		printRandom(1, 10);
		
	}
	
	
	/**
	 * @min 최소값
	 * @max 최대값 
	*/
	public static void printRandom(int min, int max)
	{
		Random r = new Random();
		System.out.println(r.nextInt(max-min+1)+min);
	}
	
}
