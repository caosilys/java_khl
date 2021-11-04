package day7;

import java.util.Random;

public class RandomEx1 {

	public static void main(String[] args) {
		
		int min = 0, max = 9;
		for (int i = 0 ; i < 5 ; i++)
		{
			int random = (int)(Math.random()*(max-min+1)+min);
			System.out.print(random + "  ");
		}
		System.out.println();
		System.out.println("---------------");
		
		Random r = new Random();
		for(int i = 0 ; i < 5; i++)
		{
			int random = r.nextInt(max-min+1)+min;
			System.out.print(random + "  ");
		}

	}

}
