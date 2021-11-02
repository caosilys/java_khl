package day5;

public class PrimeNumEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 2;
		int i =1, count =0;
		while(num <=100)
		{
			i=1;
			count =0;
			while(i<=num)
			{
				if(num%i == 0)
				{
					count++;
				}
				i++;
			}
			if(count==2)
			{
				System.out.print(num + " ");
			}
			num++;
		}
		
//		int i = 2, j, count;
//		while(i <= 100)
//		{	
//			j=1;
//			count=0;
//			while(true)
//			{
//				if(i%j==0)
//				{
//					count++;
//					if(i==j && count==2)
//					{
//						System.out.println(i + " : 소수");
//						break;
//					}
//					else if(i==j && count!=2)
//					{
//						break;
//					}
//				}
//				j++;
//			}
//			i++;
//		}
		
		
	}

}
