package day5;

public class StarEx {

	public static void main(String[] args) {
		/*
		 *       *     
		 *     ***   
		 *    *****
		 *  *******
		 * *********
		 * */
		
		for(int i = 5 ;i >=0 ; i--)
		{	
			
			int j=i;
			for(j = 5-j;j<=5;j++)
			{
				System.out.print("  ");
			}
			j=i;
			for( ; j <=5 ; j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}

}
