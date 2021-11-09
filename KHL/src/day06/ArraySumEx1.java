package day06;


public class ArraySumEx1 {

	public static void main(String[] args) {
		// 2~10사이의 짝수들을 배열에 저장하고, 배열에 저장된 값의 합 출력

		int count = 0;
		//배열길이 확인
		for(int i = 2 ; i <=10; i++)
		{
			if(i%2==0)
			{
				count++;
			}
		}
		//배열 선언
		int arr[] = new int[count];
		
		// 배열에 값 저장
		count = 0;
		for(int i = 2 ; i <=10; i++)
		{
			if(i%2==0)
			{
				arr[count] = i;
				count++;
			}
		}
		
		// 계산
		count = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			count+= arr[i];
		}
		
		System.out.println(count);		
		
	}

}
