package day5;

public class MultiplerTableEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j=2;
		while(j <= 9)
		{	
			i=1;
			while(i <=9)
			{
				System.out.println(j + " X " + i +" = " + i*j );
				i++;
			}
			j++;
		}
	}

}
