package day08;

public class MethodArraycontainsEx1 {
		
	public static void main(String[] args) {
		
		int[] lootto = { 5 ,18 ,24 , 35, 40, 1};
		int num = 1;
	
		System.out.println("중복되는가? : " + duplicate(lootto, num));
	}
	
	
	public static boolean duplicate(int[] array, int num)
	{
		for(int i = 0; i < array.length ; i++)
		{
			if(array[i]==num)
			{
				return true;
			}
		}
		return false;
	}
	
	

}
