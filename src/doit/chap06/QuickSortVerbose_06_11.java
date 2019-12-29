package doit.chap06;

import java.util.Scanner;

import doit.chap04.IntStack;

public class QuickSortVerbose_06_11 {
	
	// 배열의 요소 a[idx1]과 a[idx2]를 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 퀵정렬(비재귀버전)
	static void quickSort(int[] a, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1);	//나눌 범위의 왼쪽 끝 요소의 인덱스를 저장하는 스택
		IntStack rstack = new IntStack(right - left + 1);	//나눌 범위의 오른쪽 끝 요소의 인덱스를 저장하는 스택
		
		lstack.push(left);
		rstack.push(right);
		
		System.out.printf("a[%d] ~ a[%d]를 분할할 범위를 스택에 푸시합니다.\n", left, right);
		System.out.print("Lstack : ");
		lstack.dump();
		System.out.print("Rstack : ");
		rstack.dump();
		
		while (lstack.isEmpty() != true) {
			//정렬할 배열의 범위
			int pl = left  = lstack.pop();		//왼쪽 커서
			int pr = right = rstack.pop();		//오른쪽 커서
			int x = a[(left + right) / 2];		//피벗
			
			System.out.printf("스택에서 분할할 범위를 꺼냈습니다. a[%d] ~ a[%d]를 분할합니다.\n", left, right);
			
			//피벗을 기준으로 하위 그룹과 상위 그룹으로 나눈다
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			
			if (left < pr) {
				lstack.push(left);		//하위 그룹 범위의
				rstack.push(pr);		//인덱스를 푸시
				
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
			}
			if (pl < right) {
				lstack.push(pl);		//상위 그룹 범위의
				rstack.push(right);		//인덱스를 푸시
				
				System.out.print("Lstack:");
				lstack.dump();
				System.out.print("Rstack:");
				rstack.dump();
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
