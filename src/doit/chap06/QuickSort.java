package doit.chap06;

import java.util.Scanner;

//퀵 정렬
public class QuickSort {
	
	//배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];  
		a[idx1] = a[idx2];  
		a[idx2] = t;
	}
	
	//퀵 정렬을 재귀 호출을 사용하여 구현
	static void quickSort(int[] a, int left, int right) {
		int pl = left;				//왼쪽 커서
		int pr = right;				//오른쪽 커서
		int x = a[(pl + pr) / 2];	//피벗
		
		//분할 과정 출력
		System.out.printf("a[%d] ~ a[%d] : {", left, right);
		for (int i = left; i < right; i++) {
			System.out.printf("%d , ", a[i]);
		}
		System.out.printf("%d}\n", a[right]);
		
		//배열 a를 피벗 x를 기준으로 나눈다
		do {
			while (a[pl] < x) pl++;
			while (a[pr] > x) pr--;
			
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);
		
		//요소의 개수가 2개 이상인 그룹만 나누기 위한 조건
		if (left < pr) quickSort(a, left, pr);		//피벗 이하인 부분
		if (pl < right) quickSort(a, pl, right);	//피벗 이상인 부분
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("퀵 정렬");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]：");
			x[i] = stdIn.nextInt();
		}

		quickSort(x, 0, nx - 1);			// 배열 x를 퀵 정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
