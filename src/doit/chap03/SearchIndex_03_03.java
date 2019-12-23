package doit.chap03;

import java.util.Scanner;

//어떤 값을 갖는 배열 안의 모든 요소를 다른 배열에 복사함
public class SearchIndex_03_03 {

	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == key)
				idx[count++] = i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("길이 : ");
		int num = scanner.nextInt();
		int[] x = new int[num]; // 요솟수 num인 배열
		int[] y = new int[num]; // 요솟수 num인 배열

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = scanner.nextInt();
		}
		System.out.print("찾는 값 : "); // 키 값을 입력 받음
		int ky = scanner.nextInt();

		int count = searchIdx(x, num, ky, y);

		if (count == 0)
			System.out.println("그 값의 요소가 없습니다.");
		else
			for (int i = 0; i < count; i++)
				System.out.println("그 값은 " + "x[" + y[i] + "]에 있습니다.");
	}
}
