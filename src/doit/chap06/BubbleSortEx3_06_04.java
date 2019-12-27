package doit.chap06;

import java.util.Scanner;

public class BubbleSortEx3_06_04 {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1]; 
		a[idx1] = a[idx2]; 
		a[idx2] = t;
	}
	
	static void bubbleSort(int[] a, int n) {
		int ccnt = 0;	//비교횟수
		int scnt = 0;	//교환횟수
		
		int i = 1;
		int k = 0;
		while (k < n - 1) {
			System.out.printf("패스%d : \n", i++);
			
			int last = n - 1;	//각 패스에서 마지막으로 교환한 오른쪽 요소 인덱스
			for (int j = n - 1; j > k; j--) {
				for (int m = 0; m < n - 1; m++) {
					System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
				}
				System.out.printf("%3d\n", a[n - 1]);
				
				ccnt++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					scnt++;
					last = j;
				}
			}
			k = last;
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

		bubbleSort(x, nx); // 배열 x를 단순교환정렬
	}
}
