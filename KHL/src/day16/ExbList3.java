package day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExbList3 {

	public static void main(String[] args) throws Exception {
		
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
			System.out.println("3. 학생정보 삭제");
			System.out.println("4. 프로그램종료");		
			int num = scan.nextInt();	
			scan.nextLine();
			switch(num)
			{
				case 1: GreanClass.add(createStd(scan)); break;
				case 2: printStd(GreanClass); break;
				case 3: deleteStd(GreanClass, scan); break;
				case 4: flag = false; System.out.println("종료합니다"); break;
				default : System.out.println("잘못 입력하셨습니다"); break;
			}
		}		
		scan.close();
	}
	
	
	
	public static ExbStudents createStd(Scanner scan) throws Exception
	{		
		System.out.println("학생정보를 입력하세요");
		System.out.println("예시 : 이름,국어,수학,영어,고유번호");
		String getInfo = scan.nextLine();
		String info[] = new String[5];
		info = getInfo.split(",");
		ExbStudents std 
		= new ExbStudents(info[0], Integer.parseInt(info[1]), 
				 Integer.parseInt(info[2]), Integer.parseInt(info[3]),
				 Integer.parseInt(info[4]));
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
	
	public static void deleteStd(List<ExbStudents> list, Scanner scan)
	{	
//		System.out.println("삭제할 이름을 입력하세요");
//		String name = scan.nextLine();		
//		for(ExbStudents i : list)
//		{
//			if(i.getName().equals(name))
//			{
//				list.remove(i);
//				System.out.println("삭제되었습니다");
//				break;
//			}
//			System.out.println("해당 학생은 없습니다");
//		}
		
		System.out.println("삭제할 고유번호를 입력하세요");
		int code = scan.nextInt();
		ExbStudents std = new ExbStudents(code);
		if(list.remove(std))
		{	
			System.out.println("삭제되었습니다");
		}
		else
		{
			System.out.println("해당하는 학생이 없습니다");
		}
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

