package day06;

import java.util.Arrays;

public class ArrayEx4 {

	public static void main(String[] args) {
		// 배열 정렬
		int num[] = {1, 10, 9, 3, 6, 2, 3, 4};
		// 버블정렬
//		for (int i = 0 ; i<num.length-1; i++)
//		{
//			for (int j = 0 ; j < num.length-1; j++)
//			{
//				int temp = num[j];
//				num[j] = num[j+i];
//				num[j+i]= temp;
//			}
//		}
		// Arrays.sort(num); 오름차순 배열정렬
		Arrays.sort(num,0,5);
		
		for(int tmp : num)
		{
			System.out.print(tmp+" ");
		}
		
		
		
	}

}
