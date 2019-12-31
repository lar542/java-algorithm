package doit.chap06;

import java.util.Scanner;

//도수 정렬
public class Fsort {
	
	//도수 정렬(0 이상 max 이하의 값을 입력한다)
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max + 1];		//도수분포와 누적도수분포를 넣는 배열
		int[] b = new int[n];			//목적 배열
		
		//도수분포표
		for (int i = 0; i < n; i++) {
			f[a[i]]++;
		}
		
		//누적도수분포표
		for (int i = 1; i <= max; i++) {
			f[i] += f[i - 1];
		}
		
		//목적 배열 만들기
		for (int i = n - 1; i >= 0; i--) {
			b[--f[a[i]]] = a[i];
		}
		
		//배열 복사하기
		for (int i = 0; i < n; i++) {
			a[i] = b[i];
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("도수 정렬");
		System.out.print("길이 : ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			do {
				System.out.print("x[" + i + "]：");
				x[i] = stdIn.nextInt();
			} while (x[i] < 0);
		}

		//배열 x의 최댓값을 구한다
		int max = x[0];
		for (int i = 1; i < nx; i++)
			if (x[i] > max) max = x[i];

		fSort(x, nx, max);				// 배열 x를 도수 정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}
