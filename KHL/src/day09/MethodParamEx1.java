package day09;

public class MethodParamEx1 {

	public static void main(String[] args) {
		// 
		
		System.out.println(sum(1,2,3,4,5));
		System.out.println((sum(2,5,7,3,3)));
	}

	// 가변 매개변수
	public static int sum(int ...nums)
	{
		int sum = 0;
		for(int i = 0; i < nums.length; i++)
		{
			sum += nums[i];
		}
		return sum;
	}
	
	

}
