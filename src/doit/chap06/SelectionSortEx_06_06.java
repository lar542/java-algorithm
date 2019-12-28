package doit.chap06;

import java.util.Scanner;

public class SelectionSortEx_06_06 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	//단순선택정렬
	static void selectionSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;		//아직 정렬하지 않는 부분에서 가장 작은 요소의 인덱스
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			
			for (int k = 0; k < n; k++) {
				System.out.printf("%3s", (k == i) ? "*" : (k == min) ? "+" : "");
			}
			System.out.println();
			
			for (int k = 0; k < n; k++) {
				System.out.printf("%3d", a[k]);
			}
			System.out.println("\n");
			
			swap(a, i, min);	//아직 정렬하지 않은 부분의 첫 요소와 가장 작은 요소를 교환
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순선택정렬");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		selectionSort(x, nx); // 배열 x를 단순선택정렬
	}
}
