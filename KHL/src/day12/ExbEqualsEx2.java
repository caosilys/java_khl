package day12;

public class ExbEqualsEx2 {

	public static void main(String[] args) {
		// 문자열비교해보기
		String str1 = "Hello";
		String str2 = new String("Hello");
		String str3 = "Hello";
		String str4 = new String("Hello");
		
		if(str1 == str2)
		{
			System.out.println("둘이 같음");
		}
		else
		{
			System.out.println("둘이 다름");
		}
		
		if(str2 == str4)
		{
			System.out.println("둘이 같음");
		}
		else
		{
			System.out.println("둘이 다름");
		}
	}

}
