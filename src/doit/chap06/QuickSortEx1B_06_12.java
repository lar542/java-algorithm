package doit.chap06;

import java.util.Scanner;

import doit.chap04.IntStack;

public class QuickSortEx1B_06_12 {

	// 배열의 요소 a[idx1]과 a[idx2]를 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 퀵정렬(비재귀 버전) : 요소의 개수가 적은 그룹을 먼저 나눈다
	static void quickSort(int[] a, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1);	//나눌 범위의 왼쪽 끝 요소의 인덱스를 저장하는 스택
		IntStack rstack = new IntStack(right - left + 1);	//나눌 범위의 오른쪽 끝 요소의 인덱스를 저장하는 스택
		
		lstack.push(left);
		rstack.push(right);
		
		while (lstack.isEmpty() != true) {
			//정렬할 배열의 범위
			int pl = left  = lstack.pop();		//왼쪽 커서
			int pr = right = rstack.pop();		//오른쪽 커서
			int x = a[(left + right) / 2];		//피벗
			
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
			
			if (left < pr) {
				lstack.push(left);		//하위 그룹 범위의
				rstack.push(pr);		//인덱스를 푸시
			}
			if (pl < right) {
				lstack.push(pl);		//상위 그룹 범위의
				rstack.push(right);		//인덱스를 푸시
			}
		}
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
			System.out.println("x[" + i + "] = " + x[i]);
	}
}
