package doit.chap06;

import java.util.Scanner;

public class BinInsertionSort_06_08 {
	
	//이진 삽입 정렬
	static void binInsertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			//정렬된 부분만 이진 검색
			int key = a[i];
			int low = 0;
			int high = i - 1;
			int mid;
			int input;
			
			do {
				mid = (low + high) / 2;
				if (a[mid] == key) {
					break;
				} else if (a[mid] < key) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} while (low <= high);
			
			input = (low <= high) ? mid + 1 : high + 1;
			
			for (int j = i; j > input; j--) {
				a[j] = a[j - 1];
			}
			a[input] = key;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("이진 삽입 정렬");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		binInsertionSort(x, nx); // 배열 x를 이진삽입정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
