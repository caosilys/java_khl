package day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExbList {

	public static void main(String[] args) {
		
		List <ExbStudents> GreanClass = new ArrayList<ExbStudents>();	
		Map<String, ExbStudents> GreanClass2 = new HashMap<String, ExbStudents>();
		
//		ExbStudents Astd = new ExbStudents("Eunha", 100, 100, 100);
//		GreanClass2.put("V", Astd);		
//		System.out.println(GreanClass2.get("V").toString());
				
		Scanner scan = new Scanner(System.in);
		
		
		
		
		
		char next = 'y';
		while(next == 'y' || next == 'Y')
		{		
			try 
			{
				GreanClass.add(inputStd(scan));
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("계속하시겠습니까?");
			next = scan.next().charAt(0);
			scan.nextLine();
		}
		
		printStd(GreanClass);
		
		scan.close();

//		for(ExbStudents i : GreanClass)
//		{	
//			System.out.println(i.toString());
//		}
		
	}
	
	public static ExbStudents inputStd(Scanner scan) throws Exception
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
	
	public static void printStd(List<ExbStudents> list)
	{
		Iterator<ExbStudents> it = list.iterator();
		
		while(it.hasNext())
		{
			ExbStudents tmp = it.next();
			System.out.println(tmp);
		}
	}

}

