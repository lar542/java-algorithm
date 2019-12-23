package doit.chap03;

import java.util.Arrays;
import java.util.Scanner;

//Arrays.binarySearch에 의한 이진검색(실패할 때 삽입 포인트를 나타냄)
public class BinarySearchTesterEx_03_06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("길이 : ");
		int num = scanner.nextInt();
		int[] x = new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		
		System.out.print("x[0] : ");
		x[0] = scanner.nextInt();
		
		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = scanner.nextInt();
			} while (x[i] < x[i - 1]);
		}
		
		System.out.print("검색할 값 : ");
		int ky = scanner.nextInt();
		
		int idx = Arrays.binarySearch(x, ky);
		
		if(idx < 0) {
			System.out.println("그 값의 요소가 없습니다.");
			System.out.printf("삽입 포인트는 %d입니다.", -idx - 1);
		} else {
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
		}
	}
}
