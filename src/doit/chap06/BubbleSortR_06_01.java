package doit.chap06;

import java.util.Scanner;

//버블 정렬의 각 패스에서 비교/교환을 왼쪽에서 수행하여 가장 큰 값의 요소를 오른쪽으로 옮기기
public class BubbleSortR_06_01 {
	
	//a[idx1]과 a[idx2]의 값을 바꾼다
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a, int n) {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1])
					swap(a, j, j + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("단순교환정렬(버블정렬)");
		System.out.print("길이 : ");
		int nx = scanner.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = scanner.nextInt();
		}

		bubbleSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
