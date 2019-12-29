package doit.chap06;

import java.util.Scanner;

public class QuickSortEx1A_06_12 {
	
	// 배열의 요소 a[idx1]과 a[idx2]를 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 퀵 정렬(재귀 버전) : 요소의 개수가 적은 그룹을 먼저 나눈다
	static void quickSort(int[] a, int left, int right) {
		int pl = left;				//왼쪽 커서
		int pr = right;				//오른쪽 커서
		int x = a[(pl + pr)] / 2;	//피벗
		
		//피벗을 기준으로 하위 그룹과 상위 그룹으로 나눈다
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		
		if (pr - left < right - pl) {
			//left <-> pl
			int tmp = left;
			left = pl;
			pl = tmp;
			//pr <-> right
			tmp = pr;
			pr = right;
			right = tmp;
		}
		
		if (left < pr) quickSort(a, left, pr);		//피벗 이하인 그룹
		if (pl < right) quickSort(a, pl, right);	//피벗 이상인 그룹
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("퀵정렬 ");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
