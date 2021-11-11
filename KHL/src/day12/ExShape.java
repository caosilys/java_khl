package day12;

public class ExShape {
	
	// 도형 클래스 : 모든 도형을 대표할 수 있는 클래스
	
	// 시작, 끝점의 좌표
	protected int startX, startY, endX, endY;
	// 변의 개수
	public int side;
	
	public ExShape(int x1, int y1, int x2, int y2)
	{
		startX	 = x1 < x2 ? x1 : x2;
		startY	 = y1 < y2 ? y1 : y2;
		
		endX	 = x1 > x2 ? x1 : x2;
		endY	 = y1 > y2 ? y1 : y2;
	}
	
	public int getWidth()
	{
		return endX - startX; 
	}
	
	public int getHeight()
	{
		return endY - startY;
	}
	public void move(int x, int y)
	{
		this.endX = x + getWidth();
		this.endY = y + getHeight();
		this.startX = x;
		this.startY = y;
	}
	/** 
	 * @direction 1: 좌상방향, 2: 우상방향, 3:좌하방향, 4:우하방향
	 * */
	public void resize(int x, int y, int direction)
	{
		switch (direction) {
			case 1:
				startX = x; startY = y; break;
			case 2:
				endX = x; startY = y; break; 
			case 3:
				startX = x; endY = y; break; 
			case 4:	
				endX = x; endY = y; break;
		}
	}
	
	public void resizeWidth(int width)
	{
		endX = startX+width;
	}
	
	public void resizeHeight(int hight)
	{
		endY = startY + hight;
	}
	
	public void print()
	{
		System.out.println("-----도형-----");
		System.out.println("시작점 : ("+ startX +"," + startY +")");
		System.out.println("끝점 : ("+ endX +"," + endY +")");
	}
	
	//1. 도형그리기
	// 그릴도형을 선택하세요 (1.사각형 2.타원)
	// 점 두개를 입력하세요 (ex 1, 2, 3, 4 (1,2) (3,4))
	// 사각형을 그렸습니다.
	// 다시실행
	// 실행취소
	// 도형확인
	// 프로그램종료
}
