package day14;

public class ExaStringMethodEx1 {

	public static void main(String[] args) {
		// String replace(char oldCh, char newCh)
		
		String str = "I Like JAVA";
		
		System.out.println(str.replace('A', 'a'));
		
		System.out.println(str);
		
		str = str.replace("JAVA", "Spring");
		System.out.println(str);
		
		
		String str2 = "Apple, Orange, Banana";
		String str3[] = new String[3];
		str3 = str2.split(","	);
		
		System.out.println(str3[0]);
		System.out.println(str3[1]);
		System.out.println(str3[2].trim());
		
		String str4 = "cat.jpg";
		System.out.println(str4.endsWith(".jpg"));
			
		


	}

}
