package day10;

public class ClassShapeEx1 {

	public static void main(String[] args) {
		// 사각형을 나타내는 클래스 생성
		
		Rect1 R = new Rect1(0, 0, 5, 4);
		
		R.info();
		
		R.resize(4, 8);
		
		R.info();
		
	}

}