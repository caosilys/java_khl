package day04;

public class ForEx2 {

	public static void main(String[] args) {
		
		 /*a부터 z 까지 출력*/
		 
		 for(int i=0 ; i <26; i ++)
		 {
			 System.out.print((char)('a'+i));
		 }
		 
		 /* 정수를 역순으로 출력*/
		 System.out.println();
		 
		 int num1 = 1234;
		 
		 String text = Integer.toString(num1);
		 System.out.println("문자변환 후 자르기");
		 for(int i = text.length()-1; i >=0 ; i-- )
		 {
			System.out.print(text.charAt(i));
		 }
		 
		 System.out.println();
		 System.out.println("While 사용");
		 while(num1 != 0)
		 {
			 System.out.print(num1%10);
			 num1 = num1/10;
		 }
		 
		 System.out.println();
		 System.out.println("for 사용");
		 num1 = 54321;
		 for(; num1!=0 ; num1 = num1/10)
		 {
			 System.out.print(num1%10);		 
		 }
		 
		 
	}

}
