package doit.chap06;

import java.util.Scanner;

public class BubbleSortEx2_06_03 {

	// 배열의 요소 a[idx1]과 a[idx2]를 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a, int n) {
		int ccnt = 0;	//비교횟수
		int scnt = 0;	//교환횟수
		
		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			System.out.printf("패스%d：\n", i + 1);
			
			for (int j = n - 1; j > i; j--) {
				for (int k = 0; k < n - 1; k++) {
					System.out.printf("%3d %c", a[k], (k != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
				}
				System.out.printf("%3d\n", a[n - 1]);
				
				ccnt++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					scnt++;
					exchg++;
				}
			}
			for (int k = 0; k < n; k++) {
				System.out.printf("%3d  ", a[k]);
			}
			System.out.println();
			
			if (exchg == 0) 
				break;
		}
		
		System.out.println("비교를 " + ccnt + "회 했습니다.");
		System.out.println("교환을 " + scnt + "회 했습니다.");
	}
		
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("단순교환정렬(버블정렬)");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		bubbleSort(x, nx);
	}
}
