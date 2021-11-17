package day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExbList2 {

	public static void main(String[] args) {
		
		List <ExbStudents> GreanClass = new ArrayList<ExbStudents>();	
		Map<String, ExbStudents> GreanClass2 = new HashMap<String, ExbStudents>();
		
//		ExbStudents Astd = new ExbStudents("Eunha", 100, 100, 100);
//		GreanClass2.put("V", Astd);		
//		System.out.println(GreanClass2.get("V").toString());
				
		Scanner scan = new Scanner(System.in);
		Boolean flag = true;
		while(flag)
		{
			System.out.println("메뉴");
			System.out.println("1. 학생정보 추가");
			System.out.println("2. 전체학생정보 출력");
			System.out.println("3. 프로그램종료");
			
			int num = scan.nextInt();
			scan.nextLine();
			switch(num)
			{
				case 1: inputStd(scan, GreanClass); break;
				case 2: printStd(GreanClass); break;
				case 3: flag = false; System.out.println("종료합니다"); break;
				default : System.out.println("잘못 입력하셨습니다"); break;
			}
		}		
		scan.close();
	}
	
	public static void inputStd(Scanner scan, List<ExbStudents> list)
	{
		char next = 'y';
		while(next == 'y' || next == 'Y')
		{		
			try 
			{
				list.add(createStd(scan));
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("계속하시겠습니까?");
			next = scan.next().charAt(0);
			scan.nextLine();
		}
	}
	
	public static ExbStudents createStd(Scanner scan) throws Exception
	{		
		System.out.println("학생정보를 입력하세요");
		System.out.println("예시 : 이름,국어,수학,영어");
		String getInfo = scan.nextLine();
		String info[] = new String[4];
		info = getInfo.split(",");
		ExbStudents std 
		= new ExbStudents(info[0], Integer.parseInt(info[1]), 
				 Integer.parseInt(info[2]), Integer.parseInt(info[3]));
		return std;
	}
	
	public static void printStd(List<ExbStudents> list)	{
		Iterator<ExbStudents> it = list.iterator();
		
		while(it.hasNext())
		{
			ExbStudents tmp = it.next();
			System.out.println(tmp);
		}
	}
	
	
//	public static void inputStd(Scanner scan,  List<ExbStudents> list) throws Exception
//	{		
//		System.out.println("학생정보를 입력하세요");
//		System.out.println("예시 : 이름,국어,수학,영어");
//		String getInfo = scan.nextLine();
//		String info[] = new String[4];
//		info = getInfo.split(",");
//		ExbStudents std 
//		= new ExbStudents(info[0], Integer.parseInt(info[1]), 
//				 Integer.parseInt(info[2]), Integer.parseInt(info[3]));	
//		list.add(std);
//	}
	

}

