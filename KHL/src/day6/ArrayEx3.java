package day6;

public class ArrayEx3 {

	public static void main(String[] args) {
		// 배열복사
		// a배열 = b배열 의 경우 배열의 주소값이 넘어감
		// -> b배열이 변경되면 a배열도 변경됨
		
		int arr1[] = new int[5];
		for(int i : arr1)
		{
			arr1[i] = i;
		}
		
		int arr2[] = arr1;
		arr1[0] = 10;
		System.out.println("주소복사후 변경될경우 : " +  arr2[0]);
		
		int arr3[] = new int[arr1.length];
		// System.arraycopy(원본, 시작위치, 사본, 복사범위)
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		arr1[0] = 8;
		// arraycopy는 배열의 값만을 복사해줌 
		System.out.println("값 복사후 변경될 경우 : " + arr3[0]);
		
		
		
	}

}
