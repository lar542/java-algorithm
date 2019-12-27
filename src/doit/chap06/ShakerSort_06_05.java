package doit.chap06;

import java.util.Scanner;

public class ShakerSort_06_05 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void shakerSort(int[] a, int n) {
		int left = 0;
		int right = n - 1;
		int last = right;
		
		while (left < right) {
			
			//홀수 번째 패스 : 가장 작은 요소를 왼쪽으로
			for (int j = right; j > left; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;	//오른쪽 인덱스 저장
				}
			}
			left = last;
			
			//짝수 번째 패스 : 가장 큰 요소를 오른쪽으로
			for (int j = left; j < right; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					last = j;	//왼쪽 인덱스 저장
				}
			}
			right = last;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("양방향 버블정렬(셰이커정렬)");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		shakerSort(x, nx); // 배열 x를 양방향 버블정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
