package day14;

public class ExaStringEx1 {

	public static void main(String[] args) {
		// 5명의 이름을 저장하고 홍씨인 사람을 검색하는 코드
		
		String name[] = {"임요환", "홍진호", "최연성", "이윤열", 
							   "박정석", "홍진호호", "호홍진호"};
		
		boolean check = false;
		int count = 0;
		
		for(int i = 0; i < name.length ; i++)
		{
			if(name[i].startsWith("홍"))
			{
				System.out.println(name[i] + "는 홍씨입니다");
			}
			
			if(name[i].equals("홍진호"))
			{
				check = true;
				count++;
			}
		}
		
		if(check)
		{
			System.out.println("name[] 중에는 홍진호가" + count + "개 있습니다");
		}
		
		String fileName[]
		= {"EunHa.jpg", "Umji.gif", "Kakaotalk.exe", "DnF.exe", "ExString.java"};
		
		boolean checkImage = false;
		
		for(int i = 0 ; i < fileName.length ; i++)
		{
			if( fileName[i].endsWith(".jpg") || fileName[i].endsWith(".gif") 
			|| fileName[i].endsWith(".png") || fileName[i].endsWith(".bmp") )
			{
				checkImage = true;
				break;
			}
		}
		
		if(checkImage)
		{
			System.out.println("fileName 에는 이미지가 있다");
		}
		else
		{
			System.out.println("fileName 에는 이미지가 없다");
		}
		
		// 확장자들과 파일명이 주어지면 해당 파일이 확장자에 맞는지 알려주는 메소드
		// String[]suffixArrary, String fileName
		// 리턴타입 boolean
	}
	
	public static boolean checkSuffix (String[]suffixArrary, String fileName )
	{
		for(int i = 0 ; i < suffixArrary.length ; i++)
		{
			if(suffixArrary[i].endsWith(fileName))
			{
				return true;
			}
		}
		
		return false;
	}

}
